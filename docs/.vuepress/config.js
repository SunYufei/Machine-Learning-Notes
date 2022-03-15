const getSidebar = require('./sidebar')

module.exports = {
   locales: {
      '/': {
         lang: 'zh-CN',
         title: '知识库',
         description: 'Accumulating Knowledge',
      },
   },
   plugins: {
      '@vuepress/back-to-top': {},
      '@vuepress/nprogress': {},
      pangu: {},
   },
   themeConfig: {
      // activeHeaderLinks: false,
      // displayAllHeaders: false,
      lastUpdated: '最近更新',
      nav: [
         { text: '博客', link: 'https://blog.sunyufei.ml' },
         { text: 'GitHub', link: 'https://github.com/SunYufei/' },
      ],
      nextLinks: true,
      prevLinks: true,
      searchMaxSuggestions: 10,
      sidebar: getSidebar(
         '/java/',
         '/db/',
         '/spring/',
         '/git.md',
         '/os/',
         '/net/',
         '/algorithm/',
         '/design-pattern/',
         '/middle-ware/',
         '/ORM/',
         '/micro-service/',
         '/container/',
         '/architecture/',
         '/front-end/',
         '/others/'
      ),
      smoothScroll: true,
   },
}
