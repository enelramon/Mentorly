package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.api.PeerReviewMentorlyApi
import com.sagrd.mentorly.data.remote.dto.CreatePeerReviewRequestDto
import com.sagrd.mentorly.data.remote.dto.PeerReviewDto
import com.sagrd.mentorly.data.remote.dto.PeerReviewResultDto
import com.sagrd.mentorly.data.remote.dto.SubmitPeerReviewRequestDto
import javax.inject.Inject

class PeerReviewRemoteDataSource @Inject constructor(
    private val api: PeerReviewMentorlyApi
) {
    suspend fun getPeerReviews(): Result<List<PeerReviewDto>> {
        return try {
            val response = api.getPeerReviews()
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.message()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Error desconocido"))
        }
    }

    suspend fun getPeerReview(id: String): Result<PeerReviewDto> {
        return try {
            val response = api.getPeerReview(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.message()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Error desconocido"))
        }
    }

    suspend fun submitReview(dto: CreatePeerReviewRequestDto): Result<PeerReviewResultDto> {
        return try {
            val response = api.submitReview(dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.message()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Error desconocido"))
        }
    }

    suspend fun updatePeerReview(id: String, dto: SubmitPeerReviewRequestDto): Result<Boolean> {
        return try {
            val response = api.updatePeerReview(id, dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.message()}"))
            } else {
                Result.success(true)
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Error desconocido"))
        }
    }

    suspend fun deletePeerReview(id: String): Result<Boolean> {
        return try {
            val response = api.deletePeerReview(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.message()}"))
            } else {
                Result.success(true)
            }
        } catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Error desconocido"))
        }
    }
}