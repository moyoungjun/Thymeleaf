package com.example.springboot.service

import com.example.springboot.dto.UserCreationRequest
import com.example.springboot.dto.UserLoginRequest
import com.example.springboot.dto.UserResponse
import com.example.springboot.entity.User
import com.example.springboot.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): UserDetailsService {
    /**
     * UserDetailService를 상속받아 메소드를 오버라이딩 합니다.
     * DB로부터 회원정보를 가져와 존재여부를 확인합니다.
     * @param username user Id
     * @return user 반환
     */
    override fun loadUserByUsername(username: String): UserDetails {

        val principal: User = userRepository.findByUsername(username) ?:  throw UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : $username")
            println(principal)
        return principal
    }

    @Transactional
    fun register(userCreationRequest: UserCreationRequest): UserResponse {
        val user = User(userCreationRequest)
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
        return UserResponse(user)
    }

    fun login(userLoginRequest: UserLoginRequest): UserResponse{
        val user = userRepository.findByUsername(userLoginRequest.username)
            ?: throw  UsernameNotFoundException(userLoginRequest.username)
        return UserResponse(user)
    }

}