package com.example.springboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests {
                authorizeRequests ->
                  authorizeRequests.antMatchers("/static/**","/register").permitAll()
                      .anyRequest().authenticated()
            }
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .failureUrl("/login?error")
            .and()
            .logout()
            .logoutSuccessUrl("/")
        return http.build()
    }


}