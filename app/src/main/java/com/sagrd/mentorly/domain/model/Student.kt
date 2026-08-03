package com.sagrd.mentorly.domain.model

data class Student(
    val id: String,
    val googleUserId: String,
    val email: String,
    val displayName: String
)