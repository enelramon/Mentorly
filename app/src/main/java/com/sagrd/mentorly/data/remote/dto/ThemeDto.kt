package com.sagrd.mentorly.data.remote.dto

data class ThemeDto(
    val id: String,
    val unitId: String,
    val title: String,
    val contentText: String,
    val orderIndex: Int,
    val activites: List<ActivityDto>
)

data class CreateThemeDto(
    val title: String,
    val contentText: String,
    val orderIndex: Int,
    val activities: List<CreateActivityDto>?
)
