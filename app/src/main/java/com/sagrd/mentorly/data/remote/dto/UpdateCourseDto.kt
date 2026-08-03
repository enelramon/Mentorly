package com.sagrd.mentorly.data.remote.dto

data class UpdateCourseDto(
    val title: String,
    val description: String,
    val requiredPeerReviews: Int,
)