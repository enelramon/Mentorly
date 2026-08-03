package com.sagrd.mentorly.domain.enum

enum class ApprovalStrategy(val value: Int) {
    AUTO(1),
    PEER_REVIEW(2),
    ADMIN(3);

    companion object {
        fun fromValue(value: Int): ApprovalStrategy =
            entries.first { it.value == value }
    }
}