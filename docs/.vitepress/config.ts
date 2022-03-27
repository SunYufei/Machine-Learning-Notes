import { defineConfig } from 'vitepress'

export default defineConfig({
   locales: {
      '/': {
         lang: 'zh-CN',
         title: 'Notes',
         description: 'Java, 数据库, 算法, ...',
      },
   },
   themeConfig: {
      lastUpdated: '最近更新',
      nextLinks: true,
      prevLinks: true,
      nav: [
         {
            text: 'Java',
            items: [
               { text: 'Java基础⭐⭐⭐⭐⭐', link: '' },
               { text: 'Java并发⭐⭐⭐⭐', link: '' },
               { text: 'JVM', link: '' },
            ],
         },
         { text: '设计模式', link: 'design-pattern' },
         { text: '算法', items: [{ text: '', link: '' }] },
         {
            text: '数据库',
            items: [
               { text: '数据库基础', link: 'db/' },
               { text: 'SQL', link: 'sql/' },
               { text: 'MySQL⭐⭐⭐⭐⭐', link: '' },
               { text: 'Redis', link: 'redis' },
            ],
         },
         {
            text: '框架',
            items: [
               { text: 'Spring 5⭐⭐⭐⭐⭐', link: 'spring/' },
               { text: 'SpringMVC⭐⭐⭐⭐⭐', link: 'spring/' },
               { text: 'SpringBoot⭐⭐⭐⭐⭐', link: 'spring/' },
               { text: 'MyBatis⭐⭐⭐⭐⭐', link: '' },
               { text: 'MyBatisPlus⭐⭐⭐', link: '' },
            ],
         },
         { text: '前端', link: 'front-end/' },
         {
            text: '工具｜部署',
            items: [
               { text: 'git⭐⭐⭐⭐⭐', link: 'git' },
               { text: '容器技术⭐⭐⭐⭐', link: 'container/' },
               { text: '容器编排⭐⭐⭐⭐', link: 'container/' },
            ],
         },
         { text: '微服务', link: 'micro-service' },
         {
            text: '架构',
            items: [
               { text: '分布式⭐⭐⭐⭐', link: '' },
               { text: '高可用⭐⭐⭐', link: '' },
               { text: '高并发⭐⭐⭐', link: '' },
               { text: '服务网络', link: '' },
               { text: 'DDD领域驱动网络', link: '' },
               { text: '其他', link: '' },
            ],
         },
         { text: '操作系统', link: 'os/' },
         { text: '网络', link: 'net/' },
         {
            text: '其它',
            items: [
               { text: '博客', link: 'https://blog.sunyufei.ml' },
               { text: 'C++', link: '' },
               { text: 'ML', link: '' },
               { text: 'MQTT物联网', link: '' },
            ],
         },
         { text: 'GitHub', link: 'https://github.com/sunyufei' },
      ],
      sidebar: 'auto',
   },
})
