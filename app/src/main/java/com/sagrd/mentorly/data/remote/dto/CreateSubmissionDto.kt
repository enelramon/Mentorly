package com.sagrd.mentorly.data.remote.dto

data class CreateSubmissionDto(
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String
)