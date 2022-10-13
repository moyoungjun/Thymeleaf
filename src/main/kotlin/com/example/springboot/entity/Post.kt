package com.example.springboot.entity

import com.example.springboot.config.BaseTime
import com.example.springboot.dto.PostCreationRequest
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int ?= null,

    val title: String,

    val content: String

): BaseTime() {
    constructor(postCreationRequest: PostCreationRequest): this(
        title = postCreationRequest.title,
        content = postCreationRequest.content
    )

}