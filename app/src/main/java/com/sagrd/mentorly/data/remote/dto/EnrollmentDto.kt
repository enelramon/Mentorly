package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.model.Enrollment

data class EnrollmentDto(
    val id: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAt: String,
    val expiresAt: String,
    val status: Int,
    val certificateUrl: String?
) {
    fun toDomain() = Enrollment(
        id = id,
        studentId = studentId,
        courseId = courseId,
        attemptNumber = attemptNumber,
        startedAt = startedAt,
        expiresAt = expiresAt,
        status = status,
        certificateUrl = certificateUrl
    )
}

