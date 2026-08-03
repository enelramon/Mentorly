package com.sagrd.mentorly.domain.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.model.PeerReviewResult
import kotlinx.coroutines.flow.Flow

interface PeerReviewRepository {
    fun submitReview(submissionId: String, reviewerStudentId: String, isApproved: Boolean, feedbackComment: String): Flow<Resource<PeerReviewResult>>
}