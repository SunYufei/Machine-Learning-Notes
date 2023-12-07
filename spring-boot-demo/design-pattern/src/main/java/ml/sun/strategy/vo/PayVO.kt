package ml.sun.strategy.vo

import ml.sun.strategy.enums.PayTemplate
import java.time.LocalDateTime

data class PayVO(val time: LocalDateTime, val template: PayTemplate, val orderNo: String, val userId: String) {
    constructor(orderInfo: OrderInfoVO) : this(
        LocalDateTime.now(), orderInfo.template, orderInfo.orderNo, orderInfo.userId
    )
}
