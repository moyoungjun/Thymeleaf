package com.example.springboot.service

import com.example.springboot.dto.PostCreationRequest
import com.example.springboot.dto.PostResponse
import com.example.springboot.entity.Post
import com.example.springboot.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun get(): List<PostResponse>{
        return postRepository.findAll().map{ PostResponse(it) }
    }

    fun getId(id: Int): PostResponse {
        val result = postRepository.findById(id).orElseThrow{ Exception() }
        return PostResponse(result)
    }

    fun post(postCreationRequest: PostCreationRequest): PostResponse{
        val post = Post(postCreationRequest)
        postRepository.save(post)
        return PostResponse(post)
    }
}