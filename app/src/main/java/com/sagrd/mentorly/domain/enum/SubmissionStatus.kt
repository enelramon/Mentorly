package com.sagrd.mentorly.domain.enum

enum class SubmissionStatus(val value: Int) {
    PENDING(1),
    APPROVED(2),
    REJECTED(3),
    ESCALATED(4);

    companion object {
        fun fromValue(value: Int): SubmissionStatus =
            entries.first { it.value == value }
    }
}