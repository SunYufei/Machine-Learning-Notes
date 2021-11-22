const getSidebar = require('./sidebar');

module.exports = {
    locales: {
        '/': {
            lang: 'zh-CN',
            title: 'Notes',
            description: 'Accumulating Knowledge'
        }
    },
    plugins: {
        '@vuepress/back-to-top': {},
        '@vuepress/nprogress': {},
        'pangu': {}
    },
    themeConfig: {
        // activeHeaderLinks: false,
        // displayAllHeaders: false,
        lastUpdated: '最近更新',
        nav: [
            { text: '博客', link: 'https://sunyufei.ml' },
            { text: 'GitHub', link: 'https://github.com/SunYufei/' }
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
            '/micro-service/',
            '/container/',
            '/architecture/',
            '/front-end/'
        ),
        smoothScroll: true
    }
}