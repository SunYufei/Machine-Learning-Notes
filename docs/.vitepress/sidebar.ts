import fs from 'fs'
import path from 'path'

const docs = path.resolve(__dirname, '../../docs')

function getTitle(absDir: string, h1: boolean = true) {
   let content = ''
   const stat = fs.statSync(absDir)
   if (stat.isDirectory()) {
      // 对于目录，标题检查来源
      // 1. .title
      // 2. README.md
      // 2.1 front matter 'title: '
      // 2.2 H1
      const absTitle = path.join(absDir, '.title')
      let exist = fs.existsSync(absTitle)
      if (exist) return fs.readFileSync(absTitle, 'utf-8')
      const absReadme = path.join(absDir, 'README.md')
      let exists = fs.existsSync(absReadme)
      if (!exists) return path.basename(absDir)
      content = fs.readFileSync(absReadme, 'utf-8')
   }
   if (stat.isFile()) content = fs.readFileSync(absDir, 'utf-8')
   const front = /---(.*?)---/gs.exec(content)
   if (front != null) {
      const title = /title: (.*)/g.exec(front[1])
      if (title != null) return title[1]
   }
   // front != null && title == null
   // front == null
   if (h1 == true) {
      const h1 = /^# (.*)/g.exec(content)
      if (h1 != null) return h1[1]
   }
   // no h1
   return null
}

function getChildren(dir, readmeTitle = '概述') {
   const absDir = path.join(docs, dir)
   const children = []
   const absReadme = path.join(absDir, 'README.md')
   const exists = fs.existsSync(absReadme)
   if (exists) {
      const title = getTitle(absReadme, false) || readmeTitle
      children.push([dir, title])
   }
   for (const item of fs.readdirSync(absDir)) {
      if (item == 'README.md' || item == '.title') continue
      const absItem = path.join(absDir, item)
      const relItem = path.join(dir, item).replace(/\\/g, '/')
      const stat = fs.statSync(absItem)
      if (stat.isFile()) {
         const title = getTitle(absItem)
         children.push([relItem, title])
      }
      if (stat.isDirectory()) {
         const grandChildren = getChildren(relItem)
         if (grandChildren.length <= 0) continue
         let title
         if (children[0][0] == relItem) title = children[0][1]
         else title = path.basename(absItem)
         children.push({
            title: title,
            children: grandChildren,
         })
      }
   }
   return children
}

function getSidebar(...items) {
   const sidebar = []
   for (const item of items) {
      const absItem = path.join(docs, item)
      const title = getTitle(absItem)
      const stat = fs.statSync(absItem)
      if (stat.isFile()) {
         sidebar.push([item, title])
      } else if (stat.isDirectory()) {
         const children = getChildren(item)
         if (children.length <= 0) continue
         sidebar.push({
            title: title,
            children: children,
         })
      }
   }
   return sidebar
}
