package com.sagrd.mentorly.domain.enum

enum class UserRole(val value: Int) {
    STUDENT(1),
    ADMIN(2);

    companion object {
        fun fromValue(value: Int): UserRole =
            entries.first { it.value == value }
    }
}