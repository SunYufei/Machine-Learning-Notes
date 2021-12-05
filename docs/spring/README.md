# Spring⭐⭐⭐⭐⭐

- Mapper / DAO：Data Access Object，数据持久层，对数据库进行持久化操作。在 DAO 层里写接口，SQL 语句写在 Mapper 文件里。
- Service：业务层 / 服务层，负责业务模块的逻辑应用设计。 Service 层的实现，具体调用到已经定义的 DAO 接口，封装 Service 层的业务逻辑有利于通用的业务逻辑的独立性和重复利用性。如果把 DAO 层当作积木，那么 Service 层则是对积木的搭建。
- Impl：Implement，实现接口
- Controller，负责具体业务模块流程的控制。调用 Service 层接口控制业务流程。
- POJO / Entity：Plain Ordinary Java Object，数据库实体类。
- BO：Business Object，业务对象。把业务逻辑封装成一个对象，通过调用 DAO 方法，结合 PO 或 VO 进行业务操作。
- VO：Value Object 值对象，业务层之间数据传递。
- PO：Persistant Object，持久层对象，对应数据库中表的字段，一个 PO 是数据库中的一条记录。
- DTO：Data Transfer Object，数据传输对象。

## Spring 5⭐⭐⭐⭐⭐

Java轻量级应用框架

- IoC控制反转
- AOP面向切片编程

## SpringMVC⭐⭐⭐⭐⭐

Java轻量级Web开发框架

- 什么是 MVC？
- 请求与响应
- Restful API
- 拦截器
- 配置
- 执行过程

## Spring Boot⭐⭐⭐⭐⭐

自动配置，开箱即用

- 常用注解
- 资源整合
- 高级特性
- 本地热部署

### 整合WebServer

#### Web 服务器

- Nginx

#### 应用服务器

- Tomcat
- Jetty

### 整合数据库

#### ORM层框架

##### MyBatis

数据访问框架，操作数据库进行增删改查等操作

- 增删改查
- 全局配置
- 动态 SQL
- 缓存
- 和其他框架的整合
- 逆向工程

##### MyBatis Plus

Mybatis 的增强工具，能够简化开发、提高效率

- 引入
- 通用 CRUD
- 条件构造器
- 代码生成器
- 插件扩展
- 自定义全局操作

#### 连接池

- druid

#### 分库分表

- MyCat
- Shading-JDBC
- Shading-Sphere

### 整合搜索引擎

- ElasticSearch
- Solr

### 整合权限

#### Shiro

#### Spring Security⭐⭐⭐

Spring 的安全管理框架

- 用户认证
- 权限管理

### 整合中间件

#### 缓存

##### Redis分布式缓存

1. 5大数据类型
2. 事务
3. 消息通知
4. 管道
5. 持久化
6. 集群

##### Memcache

#### 消息队列

1. RocketMQ
2. RabbitMQ
3. Kafka

#### RPC框架

1. Dubbo
2. gRPC
3. Thrift
4. Spring Cloud
5. Netty

#### NIO（非阻塞）框架

## Maven / Gradle

项目管理工具

- 构建
- 依赖管理
- 插件
- 配置
- 子父工程
- 多模块打包构建
- Nexus 私服搭建

#### 经典面试题

1. Spring 的 IOC 和 AOP 是什么，有哪些优点？
2. Spring 框架用到了哪些设计模式？
3. 介绍 Spring Bean 的生命周期
4. MyBatis 如何实现延迟加载？
5. 介绍 MyBatis 的多级缓存机制

## 资源

视频（按顺序看）

- ⭐ [尚硅谷最新版 JavaWeb 全套教程](https://www.bilibili.com/video/BV1Y7411K7zz)（前端部分最好也看下）
- ⭐ [尚硅谷 - Spring 5 框架最新版教程（idea版）](https://www.bilibili.com/video/BV1Vf4y127N5)
- ⭐ [尚硅谷 - SpringMVC 2021 最新教程](https://www.bilibili.com/video/BV1Ry4y1574R)
- ⭐ [尚硅谷 - MyBatis 实战教程全套完整版](https://www.bilibili.com/video/BV1mW411M737)
- ⭐ [尚硅谷 - MyBatisPlus 教程](https://www.bilibili.com/video/BV1Ds411E76Y)
- [Maven 零基础入门教程](https://www.bilibili.com/video/BV1TW411g7hP)（搞不懂 Maven 可以看看）
- ⭐ [雷丰阳 2021 版 SpringBoot2 零基础入门](https://www.bilibili.com/video/BV19K4y1L7MT)
- [尚硅谷 - SpringSecurity 框架教程](https://www.bilibili.com/video/BV15a411A7kP)
