package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.api.SubmissionMentorlyApi
import com.sagrd.mentorly.data.remote.dto.CreateSubmissionDto
import com.sagrd.mentorly.data.remote.dto.SubmissionDto
import com.sagrd.mentorly.data.remote.dto.UpdateSubmissionDto
import retrofit2.HttpException
import javax.inject.Inject

class SubmissionRemoteDataSource @Inject constructor(
    private val api: SubmissionMentorlyApi
) {
    suspend fun getSubmissions(enrollmentId: String?, activityId: String?): Result<List<SubmissionDto>> {
        return try {
            val response = api.getSubmissions(enrollmentId, activityId)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                Result.success(response.body() ?: emptyList())
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun getSubmissionDetail(id: String): Result<SubmissionDto> {
        return try {
            val response = api.getSubmissionDetail(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                val body = response.body()
                if (body != null) Result.success(body)
                else Result.failure(Exception("Respuesta vacía del servidor"))
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun submitExercise(dto: CreateSubmissionDto): Result<SubmissionDto> {
        return try {
            val response = api.submitExercise(dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                val body = response.body()
                if (body != null) Result.success(body)
                else Result.failure(Exception("Respuesta vacía del servidor"))
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun updateSubmission(id: String, dto: UpdateSubmissionDto): Result<Unit> {
        return try {
            val response = api.updateSubmission(id, dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                Result.success(Unit)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun deleteSubmission(id: String): Result<Unit> {
        return try {
            val response = api.deleteSubmission(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                Result.success(Unit)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }
}