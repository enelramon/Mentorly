package com.sagrd.mentorly.data.remote.dto

data class LeaderboardEntryDto(
    val rank: Int,
    val studentId: String,
    val displayName: String,
    val totalPoints: Int,
    val isPrivateProfile: Boolean
)

data class DropOffMetricDto(
    val courseId: String,
    val courseTitle: String,
    val totalEnrolled: Int,
    val completedCount: Int,
    val expiredCount: Int,
    val dropOffPercentage: Double
)

data class CompletionTimeMetricDto(
    val courseId: String,
    val courseTitle: String,
    val averageCompletionDays: Double
)

data class BottleneckMetricDto(
    val activityId: String,
    val activityTitle: String,
    val pendingPeerReviewCount: Int
)

data class EnrollmentHistoryDto(
    val studentId: String,
    val studentName: String,
    val courseId: String,
    val courseTitle: String,
    val attemptNumber: Int,
    val status: String,
    val startedAt: String,
    val expiresAt: String
)