package com.sagrd.mentorly.domain.enum

enum class ActivityType(val value: Int) {
    EXERCISE(1),
    QUIZ(2);

    companion object {
        fun fromValue(value: Int): ActivityType =
            entries.first { it.value == value }
    }
}