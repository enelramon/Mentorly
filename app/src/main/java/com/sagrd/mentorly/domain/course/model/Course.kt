package com.sagrd.mentorly.domain.course.model

data class Course(
    val id: String,
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val isPublished: Boolean,
    val requiredPeerReviews: Int,
    val createdAt: String
)