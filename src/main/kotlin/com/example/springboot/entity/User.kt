package com.example.springboot.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    private val username: String,

    private var password: String,

    var email: String,

    val birth: LocalDate,

    val code: String,



    ) {
}