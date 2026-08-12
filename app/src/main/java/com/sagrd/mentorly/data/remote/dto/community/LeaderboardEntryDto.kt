package com.sagrd.mentorly.data.remote.dto.community

import com.sagrd.mentorly.domain.model.community.LeaderboardEntry

data class LeaderboardEntryDto(
    val position: Int,
    val studentId: String,
    val name: String,
    val points: Int,
    val photoUrl: String? = null
) {
    fun toDomain() = LeaderboardEntry(
        position = position,
        studentId = studentId,
        name = name,
        points = points,
        photoUrl = photoUrl
    )
}
