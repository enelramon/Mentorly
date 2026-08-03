package com.sagrd.mentorly.data.remote.dto

import com.sagrd.mentorly.domain.enum.ActivityType
import com.sagrd.mentorly.domain.enum.ApprovalStrategy
import com.sagrd.mentorly.domain.enum.EnrollmentStatus
import com.sagrd.mentorly.domain.enum.SubmissionStatus
import com.sagrd.mentorly.domain.enum.UserRole
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class EnumMoshiAdapters {

    @ToJson
    fun toJson(value: ActivityType): Int = value.value
    @FromJson
    fun fromJson(value: Int): ActivityType = ActivityType.fromValue(value)

    @ToJson fun toJson(value: ApprovalStrategy): Int = value.value
    @FromJson fun fromJsonApprovalStrategy(value: Int): ApprovalStrategy = ApprovalStrategy.fromValue(value)

    @ToJson fun toJson(value: EnrollmentStatus): Int = value.value
    @FromJson fun fromJsonEnrollmentStatus(value: Int): EnrollmentStatus = EnrollmentStatus.fromValue(value)

    @ToJson fun toJson(value: SubmissionStatus): Int = value.value
    @FromJson fun fromJsonSubmissionStatus(value: Int): SubmissionStatus = SubmissionStatus.fromValue(value)

    @ToJson fun toJson(value: UserRole): Int = value.value
    @FromJson fun fromJsonUserRole(value: Int): UserRole = UserRole.fromValue(value)
}
