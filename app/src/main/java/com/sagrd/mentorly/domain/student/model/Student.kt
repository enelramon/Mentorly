package com.sagrd.mentorly.domain.student.model

data class Student(
    val id: String,
    val googleUserId: String,
    val email: String,
    val displayName: String
)