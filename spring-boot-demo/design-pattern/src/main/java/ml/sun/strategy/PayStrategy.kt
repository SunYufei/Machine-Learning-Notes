package ml.sun.strategy

import ml.sun.strategy.enums.PayTemplate
import java.util.concurrent.ConcurrentHashMap

object PayStrategy {
    private val map: MutableMap<PayTemplate, IPayService> = ConcurrentHashMap()

    fun getService(template: PayTemplate) = map[template]

    fun register(template: PayTemplate, service: IPayService) {
        map[template] = service
    }
}