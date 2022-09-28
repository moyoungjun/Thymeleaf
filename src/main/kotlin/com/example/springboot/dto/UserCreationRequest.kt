package com.example.springboot.dto

import java.time.LocalDate

data class UserCreationRequest(
    var username: String,
    var password: String,
    var email: String,
    var birth: LocalDate,
    var code: String
    )
