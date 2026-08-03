package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.SubmissionStatus

data class CreatePeerReviewRequestDto (
    val submissionId: String,
    val reviewerStudentId: String,
    val isApproved: Boolean,
    val feedbackComment: String,
    val createdAtUtc: String
)

data class PeerReviewResultDto (
    val peerReviewId: String,
    val submissionId: String,
    val reviewerStudentId: String,
    val isApproved: Boolean,
    val feedbackComment: String,
    val createdAtUtc: String,
    val positiveReviews: Int,
    val requiredPositiveReviews: Int,
    val submissionStatus: SubmissionStatus
)
