package com.sagrd.mentorly.domain.model

import com.sagrd.mentorly.domain.enum.SubmissionStatus
import java.time.OffsetDateTime

data class Submission(
    val id: String,
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String?,
    val status: SubmissionStatus,
    val submittedAt: String,
    val reviewedAt: String?
)