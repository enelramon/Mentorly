package com.sagrd.mentorly.domain.model.mentorly.model

import com.sagrd.mentorly.domain.enum.EnrollmentStatus
import java.time.OffsetDateTime


data class Enrollment(
    val id: String,
    val studentId: String,
    val courseId: String,
    val attemptNumber: Int,
    val startedAt: OffsetDateTime,
    val expiresAt: OffsetDateTime,
    val status: EnrollmentStatus = EnrollmentStatus.ACTIVE,
    val certificateUrl: String? = null
)
