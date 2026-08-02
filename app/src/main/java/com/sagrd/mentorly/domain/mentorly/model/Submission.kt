package com.sagrd.mentorly.domain.mentorly.model

import com.sagrd.mentorly.domain.mentorly.enum.SubmissionStatus
import java.time.OffsetDateTime


data class Submission(
    val id: String,
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String,
    val status: SubmissionStatus = SubmissionStatus.PENDING,
    val submittedAt: OffsetDateTime,
    val reviewedAt: OffsetDateTime? = null
)
