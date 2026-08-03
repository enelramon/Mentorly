package com.sagrd.mentorly.domain.usecase.peerreview

import com.sagrd.mentorly.domain.repository.PeerReviewRepository
import jakarta.inject.Inject

class UpdatePeerReviewUseCase @Inject constructor(
    private val repository: PeerReviewRepository
) {
    operator fun invoke(id: String, submissionId: String, isApproved: Boolean, feedbackComment: String) =
        repository.updatePeerReview(id, submissionId, isApproved, feedbackComment)
}