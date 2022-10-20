import { defineConfig } from 'vitepress'

export default defineConfig({
   lang: 'zh-CN',
   title: 'Notes',
   description: 'Java，数据库，算法，...',
   lastUpdated: true,
   themeConfig: {
      nav: [],
      sidebar: {},
      socialLinks: [
         {
            icon: 'github',
            link: 'https://github.com/SunYufei',
         },
      ],
      outlineTitle: '目录',
      lastUpdatedText: '最近更新',
      footer: {
         message: 'All articles are under CC BY 4.0 license',
         copyright: 'Copyright (c) 2016-2022 SunYufei',
      },
   },
})
