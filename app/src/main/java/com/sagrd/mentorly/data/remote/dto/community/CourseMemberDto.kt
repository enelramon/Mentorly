package com.sagrd.mentorly.data.remote.dto.community

import com.sagrd.mentorly.domain.model.community.CourseMember

data class CourseMemberDto(
    val studentId: String,
    val name: String,
    val points: Int,
    val isPrivate: Boolean,
    val photoUrl: String? = null
) {
    fun toDomain() = CourseMember(
        studentId = studentId,
        name = name,
        points = points,
        isPrivate = isPrivate,
        photoUrl = photoUrl
    )
}
