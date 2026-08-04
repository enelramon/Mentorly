package com.sagrd.mentorly.domain.enum

enum class EnrollmentStatus(
    val value: Int
) {
    ACTIVE(1),
    COMPLETED(2),
    EXPIRED(3);

    companion object {
        fun fromValue(value: Int): EnrollmentStatus {
            return entries.firstOrNull { status ->
                status.value == value
            } ?: ACTIVE
        }
    }
}