package ml.sun.common.aspect

import ml.sun.common.annotation.RedisLimit
import ml.sun.common.util.RedisUtil
import ml.sun.exception.LimitException
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.stereotype.Component

@Aspect
@Component
class LimitAccessAspect {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val luaScript = DefaultRedisScript(
        """
            local key = KEYS[1]
            local limit = tonumber(ARGV[1])
            local current = tonumber(redis.call('get', key) or "0")
            if current + 1 > limit then
                return 0
            else
                redis.call('incrby', key, 1)
                redis.call('expire', key, ARGV[2])
                return current + 1
            end
        """.trimIndent(),
        Long::class.java
    )

    @Pointcut("@annotation(ml.sun.common.annotation.RedisLimit)")
    fun pointcut() {
    }

    @Before("pointcut()")
    fun before(joinPoint: JoinPoint) {
        val signature = joinPoint.signature as MethodSignature
        val method = signature.method

        val anno = method.getAnnotation(RedisLimit::class.java)

        val key = anno.key
        val className = method.declaringClass.name
        val methodName = method.name
        val redisKey = "$key$className$methodName"

        if (redisKey.isBlank()) {
            throw LimitException()
        }

        val count = RedisUtil.TEMPLATE.execute(
            luaScript,
            listOf(redisKey),
            anno.permits.toString(),
            anno.expires.toString()
        )
        if (count == 0L) {
            throw LimitException()
        }
    }
}