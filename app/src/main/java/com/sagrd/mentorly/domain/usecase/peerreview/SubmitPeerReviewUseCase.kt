package com.sagrd.mentorly.domain.usecase.peerreview

import com.sagrd.mentorly.domain.repository.PeerReviewRepository
import jakarta.inject.Inject


class SubmitPeerReviewUseCase @Inject constructor(
    private val repository: PeerReviewRepository
) {
    operator fun invoke(submissionId: String, reviewerStudentId: String, isApproved: Boolean, feedbackComment: String) =
        repository.submitReview(submissionId, reviewerStudentId, isApproved, feedbackComment)
}