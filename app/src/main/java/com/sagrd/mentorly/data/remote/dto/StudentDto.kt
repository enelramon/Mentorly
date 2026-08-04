package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.model.Student

data class StudentDto(
    val id: String,
    val googleUserId: String,
    val email: String,
    val displayName: String
) {
    fun toDomain() = Student(
        id = id,
        googleUserId = googleUserId,
        email = email,
        displayName = displayName
    )
}

