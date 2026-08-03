package com.sagrd.mentorly.data.remote.dto

data class CourseUnitDto(
    val id: String,
    val courseId: String,
    val title: String,
    val orderIndex: String,
    val themes: List<ThemeDto>
)

data class CreateUnitDto(
    val title: String,
    val orderIndex: String,
    val themes: List<CreateThemeDto>?
)
