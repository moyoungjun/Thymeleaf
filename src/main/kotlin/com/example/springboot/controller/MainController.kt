package com.example.springboot.controller

import com.example.springboot.dto.UserCreationRequest
import com.example.springboot.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
class MainController(
    private val userService: UserService
) {
    @GetMapping
    fun test(): String{
        return "main"
    }
//model: Model, @AuthenticationPrincipal userDetails: UserDetails
    @GetMapping("/login")
    fun login(): String {
        //model.addAttribute("username", userDetails.username)
        return "login"
    }

    @GetMapping("/register")
    fun register(): String{
        return "register"
    }
    @PostMapping("/register")
    fun registerPost(@Valid userCreationRequest: UserCreationRequest, bindingRequest: UserCreationRequest): String{
        println("aadadadadad")
        println(userCreationRequest)
        userService.regiser(userCreationRequest)
        return "register"
    }
    @RequestMapping("/login-error")
    fun loginError(model: Model): String {
        model.addAttribute("loginError", true)
        return "login"
    }

}