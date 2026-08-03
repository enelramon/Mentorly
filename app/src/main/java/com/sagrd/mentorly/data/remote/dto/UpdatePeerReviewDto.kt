package com.sagrd.mentorly.data.remote.dto

data class UpdatePeerReviewDto(
    val isApproved: Boolean,
    val feedbackComment: String
)
