package ml.sun.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HealthController::class)
class HealthControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun health() {
        mockMvc.get("/health").andExpect {
            status { isOk() }
            jsonPath("$.data") { doesNotExist() }
        }.andDo { print() }

        mockMvc.get("/health?param=test").andExpect {
            status { isOk() }
            jsonPath("$.data") { value("test") }
        }.andDo { print() }
    }
}
