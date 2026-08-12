package com.sagrd.mentorly.domain.model.community

data class CourseMember(
    val studentId: String,
    val name: String,
    val points: Int,
    val isPrivate: Boolean,
    val photoUrl: String? = null
)
