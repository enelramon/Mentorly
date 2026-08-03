package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.EnrollmentStatus

data class EnrollmentDto(
    val id: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAt: String,
    val expiresAt: String,
    val status: EnrollmentStatus,
    val certificateUrl: String?,
    val progressPercentage: Double,
    val completedThemesCount: Int,
    val approvedSubmissionsCount: Int
)

data class CreateEnrollmentRequestDto(
    val courseId: String
)

data class EnrollmentProgressDto(
    val enrollmentId: String,
    val courseId: String,
    val courseTitle: String,
    val status: EnrollmentStatus,
    val startedAt: String,
    val expiresAt: String,
    val progressPercentage: Double,
    val completeThemesIds: List<String>,
    val approvedActivityIds: List<String>
)