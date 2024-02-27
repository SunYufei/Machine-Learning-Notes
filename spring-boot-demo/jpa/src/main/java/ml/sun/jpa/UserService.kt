package ml.sun.jpa

import ml.sun.jpa.repository.UserInfoEntity
import ml.sun.jpa.repository.UserRepository
import ml.sun.jpa.vo.UserInfoVO
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun findByUsername(username: String): UserInfoVO? {
        val entity = repository.findByUsername(username) ?: return null
        return UserInfoVO(entity)
    }

    fun login(username: String, password: String) =
        repository.findByUsernameAndPassword(username, password) != null

    fun register(vo: UserInfoVO): UserInfoEntity {
        val entity = UserInfoEntity(vo)
        return if (checkUserExists(vo.username))
            entity
        else
            repository.save(entity)
    }

    private fun checkUserExists(username: String) =
        repository.findByUsername(username) != null
}