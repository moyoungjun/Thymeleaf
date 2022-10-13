package com.example.springboot.dto

import com.example.springboot.entity.Post
import java.time.LocalDateTime

class PostResponse(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime
) {
    constructor(post: Post): this(
        id = post.id!!,
        title = post.title,
        content = post.content,
        createdAt = post.createdAt
    )
}