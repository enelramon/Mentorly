package com.sagrd.mentorly.data.remote.dto

data class SubmissionDto(
    val id: String,
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String,
    val status: Int,
    val submittedAt: String,
    val reviewedAt: String?,
)

