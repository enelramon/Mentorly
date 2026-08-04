package com.sagrd.mentorly.domain.enum

enum class SubmissionStatus(
    val value: Int
) {
    PENDING(1),
    IN_REVIEW(2),
    APPROVED(3),
    REJECTED(4);

    companion object {
        fun fromValue(value: Int): SubmissionStatus {
            return entries.firstOrNull { status ->
                status.value == value
            } ?: PENDING
        }
    }
}