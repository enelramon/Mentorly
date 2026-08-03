package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.EnrollmentStatus

data class CreateEnrollmentRequestDto (
    val studentId: String,
    val courseId: String,
    val startedAtUtc: String
)

data class EnrollmentResultDto (
    val enrollmentId: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAtUtc: String,
    val expiresAtUtc: String,
    val status: EnrollmentStatus
)

data class EnrollmentStatusDto (
    val enrollmentId: String,
    val status: EnrollmentStatus,
    val startedAtUtc: String,
    val expiresAtUtc: String,
    val canSubmit: Boolean
)