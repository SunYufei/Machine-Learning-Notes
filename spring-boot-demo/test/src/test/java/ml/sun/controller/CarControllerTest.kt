package ml.sun.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(CarController::class)
class CarControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun info() {
        mockMvc.get("/car/info").andExpect {
            status { isOk() }
            jsonPath("data.license") { value("鲁A*****") }
            jsonPath("data.mobile") { value("131****0000") }
            jsonPath("data.idCard") { value("370000************") }
            jsonPath("data.bankCard") { value("622000*************") }
            jsonPath("data.owner") { value("张*") }
        }.andDo { print() }
    }
}