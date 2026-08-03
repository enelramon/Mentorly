package com.sagrd.mentorly.data.remote.dto

data class CreateStudentDto(
    val googleUserId: String,
    val email: String,
    val displayName: String
)