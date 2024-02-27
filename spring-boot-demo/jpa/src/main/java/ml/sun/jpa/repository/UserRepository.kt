package ml.sun.jpa.repository

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserInfoEntity, Int> {
    fun findByUsername(username: String): UserInfoEntity?

    fun findByUsernameAndPassword(username: String, password: String): UserInfoEntity?
}