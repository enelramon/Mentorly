package com.sagrd.mentorly.domain.model

import com.sagrd.mentorly.domain.enum.EnrollmentStatus
import java.time.OffsetDateTime


data class Enrollment(
    val id: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAt: String,
    val expiresAt: String,
    val status: String,
    val certificateUrl: String? = null
)
