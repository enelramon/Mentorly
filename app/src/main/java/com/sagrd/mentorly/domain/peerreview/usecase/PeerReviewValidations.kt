package com.sagrd.mentorly.domain.peerreview.usecase

data class PeerReviewValidation(
    val isValid: Boolean,
    val error: String? = null
)

fun validateFeedbackComment(feedbackComment: String): PeerReviewValidation {
    return when {
        feedbackComment.isBlank() -> PeerReviewValidation(false, "Debe justificar su decisión con un comentario")
        else -> PeerReviewValidation(true)
    }
}