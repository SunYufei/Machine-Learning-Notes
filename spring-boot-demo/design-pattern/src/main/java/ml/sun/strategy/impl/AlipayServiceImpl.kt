package ml.sun.strategy.impl

import ml.sun.strategy.IPayService
import ml.sun.strategy.PayStrategy
import ml.sun.strategy.enums.PayTemplate
import ml.sun.strategy.vo.OrderInfoVO
import ml.sun.strategy.vo.PayVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service

@Service
class AlipayServiceImpl : IPayService, InitializingBean {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun afterPropertiesSet() {
        PayStrategy.register(PayTemplate.ALIPAY, this)
    }

    override fun pay(orderInfo: OrderInfoVO): PayVO {
        logger.info("AlipayService")
        return PayVO(orderInfo)
    }
}