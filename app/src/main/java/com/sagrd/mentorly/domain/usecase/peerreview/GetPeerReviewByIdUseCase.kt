package com.sagrd.mentorly.domain.usecase.peerreview

import com.sagrd.mentorly.domain.repository.PeerReviewRepository
import jakarta.inject.Inject

class GetPeerReviewByIdUseCase @Inject constructor(
    private val repository: PeerReviewRepository
) {
    operator fun invoke(id: String) = repository.getPeerReview(id)
}