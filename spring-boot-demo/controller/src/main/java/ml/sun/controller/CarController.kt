package ml.sun.controller

import ml.sun.vo.CarInfoVO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("car")
class CarController {
    @GetMapping("info")
    fun info() = CarInfoVO(
        "鲁A99999",
        "13100000000",
        "370000190001010000",
        "6220000000000000000",
        "张三"
    )
}