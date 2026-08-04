package com.sagrd.mentorly.data.remote.dto

data class CreateEnrollmentDto(
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int
)