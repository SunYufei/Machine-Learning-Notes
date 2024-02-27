package ml.sun.jpa.vo

import ml.sun.jpa.repository.UserInfoEntity

data class UserInfoVO(val username: String, val password: String, val email: String) {
    constructor(entity: UserInfoEntity) : this(entity.username, entity.password, entity.email)
}
