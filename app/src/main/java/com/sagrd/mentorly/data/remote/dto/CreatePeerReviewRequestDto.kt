package com.sagrd.mentorly.data.remote.dto

data class CreatePeerReviewRequestDto(
    val submissionId: String,
    val reviewerStudentId: String,
    val isApproved: Boolean,
    val feedbackComment: String?,
    val createdAtUtc: String
)