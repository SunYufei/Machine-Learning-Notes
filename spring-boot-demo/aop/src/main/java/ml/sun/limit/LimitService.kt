package ml.sun.limit

import ml.sun.common.annotation.RedisLimit
import ml.sun.common.enums.RedisLimitKey
import org.springframework.stereotype.Service

@Service
class LimitService {
    @RedisLimit(key = RedisLimitKey.LIMIT, permits = 2, expires = 1)
    fun limit() = "ok"

    fun normal() = "ok"
}