package ml.sun.jpa

import ml.sun.jpa.vo.UserInfoVO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("jpa")
class UserServiceTest {
    @Autowired
    private lateinit var service: UserService

    private val username = "name"
    private val password = "password"
    private val email = "email"

    @Test
    @Order(1)
    fun register() {
        val entity = service.register(UserInfoVO(username, password, email))
        assertEquals(entity.username, username)
        assertEquals(entity.password, password)
        assertEquals(entity.email, email)
    }

    @Test
    @Order(2)
    fun find() {
        assertNotNull(service.findByUsername(username))
        assertNull(service.findByUsername("test"))
    }

    @Test
    @Order(3)
    fun login() {
        assertTrue(service.login(username, password))
        assertFalse(service.login(username, "test"))
    }
}
