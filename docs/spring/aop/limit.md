# AOP + Redis 接口访问频次控制

使用 Redis Lua 脚本配合 AOP 进行皆空访问频次控制

### 注解

<<< @/../spring-boot-demo/aop/src/main/java/ml/sun/common/annotation/RedisLimit.kt

<<< @/../spring-boot-demo/aop/src/main/java/ml/sun/common/enums/RedisLimitKey.kt

### AOP

<<< @/../spring-boot-demo/aop/src/main/java/ml/sun/common/aspect/LimitAccessAspect.kt

### 使用

<<< @/../spring-boot-demo/aop/src/main/java/ml/sun/limit/LimitService.kt
