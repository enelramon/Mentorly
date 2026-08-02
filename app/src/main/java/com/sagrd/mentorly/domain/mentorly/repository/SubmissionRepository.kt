package com.sagrd.mentorly.domain.mentorly.repository

import com.sagrd.mentorly.data.mentorly.Resource
import com.sagrd.mentorly.domain.mentorly.model.Submission
import kotlinx.coroutines.flow.Flow

interface SubmissionRepository {
    fun getSubmissions(
        enrollmentId: Int? = null,
        activityId: Int? = null
    ): Flow<Resource<List<Submission>>>
    fun getSubmissionDetail(id: Int): Flow<Resource<Submission>>
    fun saveSubmission(submission: Submission): Flow<Resource<Submission>>
}