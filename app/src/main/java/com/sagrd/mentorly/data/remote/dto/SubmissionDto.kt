package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.mentorly.enum.SubmissionStatus

data class SubmissionExerciseRequestDto (
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String,
    val submittedAtUtc: String
)

data class SubmissionResultDto (
    val submissionId: String,
    val enrollmentId: String,
    val activityId: String,
    val evidenceUrl: String,
    val submittedAtUtc: String,
    val status: SubmissionStatus
)
