package com.sagrd.mentorly.domain.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.model.Submission
import kotlinx.coroutines.flow.Flow

interface SubmissionRepository {
    fun getSubmissions(
        enrollmentId: String? = null,
        activityId: String? = null
    ): Flow<Resource<List<Submission>>>
    fun getSubmissionDetail(id: String): Flow<Resource<Submission>>
    fun saveSubmission(submission: Submission): Flow<Resource<Submission>>
}