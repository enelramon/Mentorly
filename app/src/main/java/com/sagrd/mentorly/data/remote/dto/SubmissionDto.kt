package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.SubmissionStatus
import com.sagrd.mentorly.domain.model.Submission

data class SubmissionDto(
    val id: String,
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String?,
    val status: Int,
    val submittedAt: String,
    val reviewedAt: String?
) {
    fun toDomain() = Submission(
        id = id,
        enrollmentId = enrollmentId,
        activityId = activityId,
        evidenceUrl = evidenceUrl,
        status = SubmissionStatus.fromValue(status),
        submittedAt = submittedAt,
        reviewedAt = reviewedAt
    )
}