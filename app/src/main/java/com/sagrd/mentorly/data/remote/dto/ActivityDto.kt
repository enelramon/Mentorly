package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.ActivityType
import com.sagrd.mentorly.domain.enum.ApprovalStrategy

data class ActivityDto(
    val id: String,
    val themeId: String,
    val title: String,
    val type: ActivityType,
    val isMandatory: Boolean,
    val approvalStrategy: ApprovalStrategy
)

data class CreateActivityDto(
    val title: String,
    val type: ActivityType,
    val isMandatory: Boolean,
    val approvalStrategy: ApprovalStrategy
)
