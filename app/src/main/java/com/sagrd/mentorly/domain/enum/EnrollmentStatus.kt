package com.sagrd.mentorly.domain.enum

enum class EnrollmentStatus(val value: Int) {
    ACTIVE(1),
    EXPIRED(2),
    COMPLETED(3);

    companion object {
        fun fromValue(value: Int): EnrollmentStatus =
            entries.first { it.value == value }
    }
}