package com.sagrd.mentorly.domain.peerreview.usecase

import com.sagrd.mentorly.domain.peerreview.repository.PeerReviewRepository
import javax.inject.Inject

class SubmitPeerReviewUseCase @Inject constructor(
    private val repository: PeerReviewRepository
) {
    operator fun invoke(
        submissionId: String,
        reviewerStudentId: String,
        isApproved: Boolean,
        feedbackComment: String
    ) = repository.submitReview(submissionId, reviewerStudentId, isApproved, feedbackComment)
}