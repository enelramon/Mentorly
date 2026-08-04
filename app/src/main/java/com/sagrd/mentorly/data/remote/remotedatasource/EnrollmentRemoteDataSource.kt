package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.api.EnrollmentMentorlyApi
import com.sagrd.mentorly.data.remote.dto.CreateEnrollmentDto
import com.sagrd.mentorly.data.remote.dto.EnrollmentDto
import retrofit2.HttpException
import javax.inject.Inject

class EnrollmentRemoteDataSource @Inject constructor(
    private val api: EnrollmentMentorlyApi
) {
    suspend fun getEnrollments(): Result<List<EnrollmentDto>> {
        return try {
            val response = api.getEnrollments()
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor: ", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido: ", e))
        }
    }

    suspend fun getEnrollmentDetail(id: String): Result<EnrollmentDto> {
        return try {
            val response = api.getEnrollmentDetail(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor:", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido:", e))
        }
    }

    suspend fun createEnrollment(
        dto: CreateEnrollmentDto
    ): Result<EnrollmentDto> {
        return try {
            val response = api.createEnrollment(dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor:", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido.", e))
        }
    }
}