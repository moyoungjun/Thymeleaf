package com.example.springboot.entity

import com.example.springboot.config.BaseTime
import com.example.springboot.dto.UserCreationRequest
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    private val username: String,

    @Column(nullable = false)
    private var password: String,

    @Column(nullable = false)
    var email: String,

    @field:NotNull
    @Column(nullable = false)
    val birth: LocalDate,

    @Column(nullable = false)
    val code: String,

    @Column(nullable = false)
    private var role: String

    ): UserDetails, BaseTime() {

    constructor(userCreationRequest: UserCreationRequest): this(
        username = userCreationRequest.username,
        password = userCreationRequest.password,
        email = userCreationRequest.email,
        birth = userCreationRequest.birth,
        code = userCreationRequest.code,
        role = "ROLE_USER"
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = ArrayList<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority(role))
        return authorities.toMutableSet()
    }

    override fun getPassword(): String {
        return password
    }
    fun setAuthorize(authorities: Set<GrantedAuthority>) {
        this.role = authorities.toString()
    }

    fun setPassword(password: String) {
        this.password = password
    }


    override fun getUsername(): String {
        return username
    }


    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun toString(): String {
        return "user ${username} ${password} ${birth} ${role}"
    }


}