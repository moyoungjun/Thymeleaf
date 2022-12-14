package com.example.springboot.controller

import com.example.springboot.dto.UserCreationRequest
import com.example.springboot.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid

@Controller
class MainController(
    private val userService: UserService
) {
    @GetMapping
    fun test(): String{
        return "/main"
    }

    @GetMapping("/login")
    fun login(): String {
        return "/login"
    }
    @GetMapping("/login/error")
    fun loginError(model: Model): String {
        model.addAttribute("loginError", true)
        return "login"
    }
    @GetMapping("/register")
    fun register(): String{
        return "enter/register"
    }
    @PostMapping("/register")
    fun registerPost(@Valid userCreationRequest: UserCreationRequest, bindingResult: BindingResult): String{
        return "enter/register"
    }
}