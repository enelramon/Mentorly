package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.SubmissionStatus
import com.sagrd.mentorly.domain.model.PeerReviewResult

data class PeerReviewResultDto(
    val peerReviewId: String,
    val submissionId: String,
    val reviewerStudentId: String,
    val isApproved: Boolean,
    val feedbackComment: String?,
    val createdAtUtc: String,
    val positiveReviews: Int,
    val requiredPositiveReviews: Int,
    val submissionStatus: Int
) {
    fun toDomain() = PeerReviewResult (
        peerReviewId = peerReviewId,
        submissionId = submissionId,
        reviewerStudentId = reviewerStudentId,
        isApproved = isApproved,
        feedbackComment = feedbackComment,
        createdAtUtc = createdAtUtc,
        positiveReviews = positiveReviews,
        requiredPositiveReviews = requiredPositiveReviews,
        submissionStatus = SubmissionStatus.fromValue(submissionStatus)
    )
}