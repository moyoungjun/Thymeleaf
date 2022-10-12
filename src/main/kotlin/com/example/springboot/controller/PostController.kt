package com.example.springboot.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PostController {

    @GetMapping("/post/write")
    fun write(): String{
        return "/post/write"
    }
}