package com.example.springboot.repository

import com.example.springboot.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Int> {
}