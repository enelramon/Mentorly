package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.SubmissionStatus

data class SubmitExerciseRequestDto(
    val activityId: String,
    val evidenceUrl: String
)

data class SubmissionDto(
    val id: String,
    val enrollmentId: String,
    val activityId: String,
    val activityTitle: String,
    val evidenceUrl: String,
    val status: SubmissionStatus,
    val submittedAt: String,
    val reviewedAt: String?,
    val receivedApprovalCounts: Int,
    val requiredApprovalCounts: Int
)

data class SubmitPeerReviewRequestDto(
    val submissionId: String,
    val isApproved: Boolean,
    val feedbackComment: String
)

data class PendingReviewSubmissionDto(
    val submissionId: String,
    val activityId: String,
    val activityTitle: String,
    val evidenceUrl: String,
    val submittedAt: String
)

data class AuditReviewDto(
    val peerReviewId: String,
    val submissionId: String,
    val authorStudentId: String,
    val authorStudentName: String,
    val reviewerStudentId: String,
    val reviewerStudentName: String,
    val isApproved: Boolean,
    val feedbackComment: String,
    val createdAt: String
)