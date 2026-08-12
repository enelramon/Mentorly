package com.sagrd.mentorly.domain.model.community

data class LeaderboardEntry(
    val position: Int,
    val studentId: String,
    val name: String,
    val points: Int,
    val photoUrl: String? = null
)
