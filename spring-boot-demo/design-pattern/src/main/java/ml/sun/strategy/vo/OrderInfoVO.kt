package ml.sun.strategy.vo

import ml.sun.strategy.enums.PayTemplate

data class OrderInfoVO(val template: PayTemplate, val orderNo: String, val userId: String)