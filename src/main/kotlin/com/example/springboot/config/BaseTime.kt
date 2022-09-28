package com.example.springboot.config

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTime {

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: LocalDateTime? = null

    @CreationTimestamp
    @Column(nullable = false)
    val updatedAt: LocalDateTime? = null

}