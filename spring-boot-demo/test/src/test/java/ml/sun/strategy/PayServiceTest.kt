package ml.sun.strategy

import ml.sun.strategy.enums.PayTemplate
import ml.sun.strategy.impl.AlipayServiceImpl
import ml.sun.strategy.impl.CashServiceImpl
import ml.sun.strategy.impl.TencentServiceImpl
import ml.sun.strategy.vo.OrderInfoVO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(AlipayServiceImpl::class, CashServiceImpl::class, TencentServiceImpl::class)
class PayServiceTest {
    @Test
    fun test() {
        // 测试样例
        val orderList = listOf(
            OrderInfoVO(PayTemplate.ALIPAY, "", ""),
            OrderInfoVO(PayTemplate.CASH, "", ""),
            OrderInfoVO(PayTemplate.TENCENT, "", "")
        )
        // 逐条测试
        orderList.forEach { order ->
            val pay = PayStrategy.getService(order.template)?.pay(order)
            assertEquals(pay?.template, order.template)
        }
    }
}