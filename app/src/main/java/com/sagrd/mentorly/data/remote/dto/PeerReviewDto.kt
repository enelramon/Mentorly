package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.SubmissionStatus
import com.sagrd.mentorly.domain.model.PeerReview
import com.sagrd.mentorly.domain.model.PeerReviewResult

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
) {
    fun toDomain(): PeerReviewResult {
        return PeerReviewResult(
            peerReviewId = peerReviewId,
            submissionId = submissionId,
            reviewerStudentId = reviewerStudentId,
            isApproved = isApproved,
            feedbackComment = feedbackComment,
            createdAtUtc = createdAtUtc,
            positiveReviews = positiveReviews,
            requiredPositiveReviews = requiredPositiveReviews,
            submissionStatus = submissionStatus
        )
    }
}

data class PeerReviewDto(
    val id: String,
    val submissionId: String,
    val isApproved: Boolean,
    val feedbackComment: String,
    val createdAt: String
) {
    fun toDomain(): PeerReview {
        return PeerReview(
            id = id,
            submissionId = submissionId,
            isApproved = isApproved,
            feedbackComment = feedbackComment,
            createdAt = createdAt
        )
    }
}