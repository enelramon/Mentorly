package com.sagrd.mentorly.domain.model

import com.sagrd.mentorly.domain.enum.SubmissionStatus

data class PeerReviewResult(
    val peerReviewId: String,
    val submissionId: String,
    val reviewerStudentId: String,
    val isApproved: Boolean,
    val feedbackComment: String?,
    val createdAtUtc: String,
    val positiveReviews: Int,
    val requiredPositiveReviews: Int,
    val submissionStatus: SubmissionStatus
)