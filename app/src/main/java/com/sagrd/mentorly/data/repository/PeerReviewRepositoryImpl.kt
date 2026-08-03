package com.sagrd.mentorly.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.dto.CreatePeerReviewRequestDto
import com.sagrd.mentorly.data.remote.dto.SubmitPeerReviewRequestDto
import com.sagrd.mentorly.data.remote.remotedatasource.PeerReviewRemoteDataSource
import com.sagrd.mentorly.domain.model.PeerReview
import com.sagrd.mentorly.domain.model.PeerReviewResult
import com.sagrd.mentorly.domain.repository.PeerReviewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant
import javax.inject.Inject

class PeerReviewRepositoryImpl @Inject constructor(
    private val peerReviewRemoteDataSource: PeerReviewRemoteDataSource
) : PeerReviewRepository {

    override fun getPeerReviews(): Flow<Resource<List<PeerReview>>> = flow {
        emit(Resource.Loading())
        peerReviewRemoteDataSource.getPeerReviews()
            .onSuccess { emit(Resource.Success(it.map { dto -> dto.toDomain() })) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    override fun getPeerReview(id: String): Flow<Resource<PeerReview>> = flow {
        emit(Resource.Loading())
        peerReviewRemoteDataSource.getPeerReview(id)
            .onSuccess { emit(Resource.Success(it.toDomain())) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun submitReview(
        submissionId: String,
        reviewerStudentId: String,
        isApproved: Boolean,
        feedbackComment: String
    ): Flow<Resource<PeerReviewResult>> = flow {
        emit(Resource.Loading())
        val dto = CreatePeerReviewRequestDto(
            submissionId = submissionId,
            reviewerStudentId = reviewerStudentId,
            isApproved = isApproved,
            feedbackComment = feedbackComment,
            createdAtUtc = Instant.now().toString()
        )
        peerReviewRemoteDataSource.submitReview(dto)
            .onSuccess { emit(Resource.Success(it.toDomain())) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    override fun updatePeerReview(
        id: String,
        submissionId: String,
        isApproved: Boolean,
        feedbackComment: String
    ): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val dto = SubmitPeerReviewRequestDto(
            submissionId = submissionId,
            isApproved = isApproved,
            feedbackComment = feedbackComment
        )
        peerReviewRemoteDataSource.updatePeerReview(id, dto)
            .onSuccess { emit(Resource.Success(it)) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }

    override fun deletePeerReview(id: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        peerReviewRemoteDataSource.deletePeerReview(id)
            .onSuccess { emit(Resource.Success(it)) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido")) }
    }
}