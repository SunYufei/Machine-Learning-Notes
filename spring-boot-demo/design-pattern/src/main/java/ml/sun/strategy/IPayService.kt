package ml.sun.strategy

import ml.sun.strategy.vo.OrderInfoVO
import ml.sun.strategy.vo.PayVO

interface IPayService {
    fun pay(orderInfo: OrderInfoVO): PayVO {
        throw RuntimeException("支付业务未支持 $orderInfo")
    }
}