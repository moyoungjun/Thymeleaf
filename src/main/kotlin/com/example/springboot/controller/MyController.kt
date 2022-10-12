package com.example.springboot.controller

import com.example.springboot.entity.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MyController {

    @GetMapping("/myPage")
    fun myPage(@AuthenticationPrincipal user: User, model: Model): String {
        model.addAttribute("user",user)
        return "/myinfo"
    }
}