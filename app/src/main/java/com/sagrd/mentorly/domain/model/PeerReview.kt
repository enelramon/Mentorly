package com.sagrd.mentorly.domain.model

data class PeerReview(
    val id: String,
    val submissionId: String,
    val isApproved: Boolean,
    val feedbackComment: String,
    val createdAt: String
)