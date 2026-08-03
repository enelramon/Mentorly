package com.sagrd.mentorly.data.remote.dto

data class CreateEnrollmentRequestDto(
    val studentId: String,
    val courseId: String,
    val startedAtUtc: String
)