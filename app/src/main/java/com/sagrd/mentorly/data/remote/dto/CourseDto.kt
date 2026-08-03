package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.model.Course

data class CourseDto(
    val id: String,
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val isPublished: Boolean,
    val requiredPeerReviews: Int,
    val createdAt: String
) {
    fun toDomain() = Course (
        id = id,
        title = title,
        description = description,
        createdByAdminId = createdByAdminId,
        isPublished = isPublished,
        requiredPeerReviews = requiredPeerReviews,
        createdAt = createdAt
    )
}
