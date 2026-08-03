package com.sagrd.mentorly.data.remote.dto

data class CreateCourseDto(
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val requiredPeerReviews: Int
)

data class UpdateCourseDto(
    val title: String,
    val description: String,
    val requiredPeerReviews: Int,
    val images: List<CreateCourseImageDto>?,
    val units: List<CreateUnitDto>?
)

data class CourseDto(
    val id: String,
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val isPublished: Boolean,
    val requiredPeerReviews: Int,
    val createdAt: String
)
