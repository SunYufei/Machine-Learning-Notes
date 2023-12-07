# Spring 中的策略模式

利用 Spring 中的 InitializingBean 接口，在 Bean 初始化时将 Bean 注册至工厂类中

## 工厂类

<<< @/../spring-boot-demo/design-pattern/src/main/java/ml/sun/strategy/PayStrategy.kt

## 工厂方法及实现

<<< @/../spring-boot-demo/design-pattern/src/main/java/ml/sun/strategy/IPayService.kt

<<< @/../spring-boot-demo/design-pattern/src/main/java/ml/sun/strategy/impl/CashServiceImpl.kt

## 调用方法

<<< @/../spring-boot-demo/test/src/test/java/ml/sun/strategy/PayServiceTest.kt
