package com.example.springboot.dto

import java.time.LocalDate
import javax.validation.constraints.NotNull

data class UserCreationRequest(
    @field:NotNull(message = "아이디")
    var username: String,
    var password: String,
    var email: String,
    var birth: LocalDate,
    var code: String
    )
