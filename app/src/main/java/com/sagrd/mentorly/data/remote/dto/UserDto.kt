package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.UserRole

data class GoogleLoginDto(
    val googleToken: String,
    val email: String,
    val displayName: String,
    val googleUserId: String
)

data class UserDto(
    val id: String,
    val googleUserId: String,
    val email: String,
    val displayName: String,
    val role: UserRole,
    val isLeaderboardPublic: Boolean,
    val totalPoints: Int
)

data class UpdatePrivacyDto(
    val isLeaderboardPublic: Boolean
)
