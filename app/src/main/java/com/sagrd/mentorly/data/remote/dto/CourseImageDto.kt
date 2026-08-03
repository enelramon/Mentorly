package com.sagrd.mentorly.data.remote.dto

data class CourseImageDto(
    val id: String,
    val courseId: String,
    val imageUrl: String,
    val altText: String,
    val isCover: Boolean,
    val orderIndex: Int
)

data class CreateCourseImageDto(
    val imageUrl: String,
    val altText: String,
    val isCover: Boolean,
    val orderIndex: Int
)
