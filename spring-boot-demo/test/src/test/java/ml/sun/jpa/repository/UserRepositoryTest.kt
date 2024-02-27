package ml.sun.jpa.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import java.time.LocalDateTime

@DataJpaTest(
    includeFilters = [ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, value = [UserRepository::class]
    )]
)
@AutoConfigureTestDatabase
class UserRepositoryTest {
    @Autowired
    private lateinit var repository: UserRepository

    private val username = "name"
    private val password = "password"
    private val email = "email"

    @BeforeEach
    fun before() {
        repository.save(UserInfoEntity(0, username, password, LocalDateTime.now(), email))
    }

    @Test
    fun findByUsername() {
        val user = repository.findByUsername(username)
        assertEquals(user?.username, username)
        assertEquals(user?.password, password)
        assertEquals(user?.email, email)
        assertNull(repository.findByUsername("test"))
    }

    @Test
    fun findByUsernameAndPassword() {
        val user = repository.findByUsernameAndPassword(username, password)
        assertEquals(user?.username, username)
        assertEquals(user?.password, password)
        assertEquals(user?.email, email)
        assertNull(repository.findByUsernameAndPassword(username, "test"))
    }
}