package ml.sun.common.annotation

import ml.sun.common.enums.RedisLimitKey

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RedisLimit(
    val key: RedisLimitKey,
    val permits: Int,
    val expires: Int = 1,
)
