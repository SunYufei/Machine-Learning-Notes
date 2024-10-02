package ml.sun.limit

import ml.sun.exception.LimitException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LimitServiceTest {
    @Autowired
    private lateinit var service: LimitService

    @Test
    fun limit() {
        assertEquals(service.limit(), "ok")
        assertEquals(service.limit(), "ok")
        assertThrows<LimitException> { service.limit() }
        assertThrows<LimitException> { service.limit() }
    }

    @Test
    fun normal() {
        assertEquals(service.normal(), "ok")
        assertEquals(service.normal(), "ok")
        assertEquals(service.normal(), "ok")
        assertEquals(service.normal(), "ok")
    }
}