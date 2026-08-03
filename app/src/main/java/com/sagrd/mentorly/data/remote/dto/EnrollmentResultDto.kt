package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.EnrollmentStatus

data class EnrollmentResultDto(
    val enrollmentId: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAtUtc: String,
    val expiresAtUtc: String,
    val status: EnrollmentStatus
)