package com.example.springboot.controller

import com.example.springboot.dto.PostCreationRequest
import com.example.springboot.service.PostService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PostController(
    private val postService: PostService
) {


    @GetMapping("/post")
    fun get(model: Model): String{
        val posts = postService.get()
        model.addAttribute("post",posts)
        return "/post/post"
    }
    @GetMapping("/post/write")
    fun main(): String{
        return "/post/write"
    }
    @GetMapping("/post/{id}")
    fun getId(@PathVariable id: Int,model: Model): String{
        val postid = postService.getId(id)
        model.addAttribute("postid",postid)
        return "/post/view"
    }
    @PostMapping("/post/write")
    fun post(postCreationRequest: PostCreationRequest): String {
        postService.post(postCreationRequest)
        return "/post/post"
    }
}