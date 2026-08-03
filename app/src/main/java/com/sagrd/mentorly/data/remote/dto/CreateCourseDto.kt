package com.sagrd.mentorly.data.remote.dto

data class CreateCourseDto(
    val title: String,
    val description: String,
    val createdByAdminId: String,
    val requiredPeerReviews: Int
)