package com.sagrd.mentorly.domain.usecase.peerreview

import com.sagrd.mentorly.domain.repository.PeerReviewRepository
import jakarta.inject.Inject

class GetPeerReviewsUseCase @Inject constructor(
    private val repository: PeerReviewRepository
) {
    operator fun invoke() = repository.getPeerReviews()
}