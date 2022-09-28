package com.example.springboot.dto

import com.example.springboot.entity.User
import java.time.LocalDate

data class UserResponse(
    val id: Long?,
    val username: String,
    val password: String,
    var email: String,
    var birth: LocalDate,
    var code: String,
    var authorities: Set<String>
) {
    constructor(user: User): this(
        id = user.id,
        username = user.username,
        password = user.password,
        email = user.email,
        birth = user.birth,
        code = user.code,
        authorities = user.authorities.map{ it.authority }.toSet()
    )
}