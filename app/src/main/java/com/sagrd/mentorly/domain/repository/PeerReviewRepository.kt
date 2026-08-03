package com.sagrd.mentorly.domain.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.model.PeerReview
import com.sagrd.mentorly.domain.model.PeerReviewResult
import kotlinx.coroutines.flow.Flow

interface PeerReviewRepository {
    fun getPeerReviews(): Flow<Resource<List<PeerReview>>>
    fun getPeerReview(id: String): Flow<Resource<PeerReview>>
    fun submitReview(
        submissionId: String,
        reviewerStudentId: String,
        isApproved: Boolean,
        feedbackComment: String
    ): Flow<Resource<PeerReviewResult>>
    fun updatePeerReview(
        id: String,
        submissionId: String,
        isApproved: Boolean,
        feedbackComment: String
    ): Flow<Resource<Boolean>>
    fun deletePeerReview(id: String): Flow<Resource<Boolean>>
}