package com.sagrd.mentorly.data.remote.dto

data class CreateCourseDto(
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val requieredPeerReviews: Int
)

data class UpdateCourseDto(
    val title: String,
    val description: String,
    val requieredPeerReviews: Int
)

data class CourseDto(
    val id: String,
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val isPublished: Boolean,
    val requieredPeerReviews: Int,
    val createdAt: String
)
