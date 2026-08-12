package com.sagrd.mentorly.data.repository.community

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.api.CourseCommunityApi
import com.sagrd.mentorly.domain.model.community.CourseMember
import com.sagrd.mentorly.domain.model.community.LeaderboardEntry
import com.sagrd.mentorly.domain.repository.community.CourseCommunityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CourseCommunityRepositoryImpl @Inject constructor(
    private val api: CourseCommunityApi,
) : CourseCommunityRepository {
    override fun getMembers(courseId: String, viewerStudentId: String): Flow<Resource<List<CourseMember>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getMembers(courseId, viewerStudentId)
            if (response.isSuccessful) {
                val members = response.body()?.map { it.toDomain() } ?: emptyList()
                emit(Resource.Success(members))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error inesperado"))
        } catch (_: IOException) {
            emit(Resource.Error("No se pudo conectar al servidor"))
        }
    }

    override fun getLeaderboard(courseId: String, viewerStudentId: String): Flow<Resource<List<LeaderboardEntry>>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getLeaderboard(courseId, viewerStudentId)
            if (response.isSuccessful) {
                val entries = response.body()?.map { it.toDomain() } ?: emptyList()
                emit(Resource.Success(entries))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error inesperado"))
        } catch (_: IOException) {
            emit(Resource.Error("No se pudo conectar al servidor"))
        }
    }

    override fun getOwnPosition(courseId: String, studentId: String): Flow<Resource<LeaderboardEntry>> = flow {
        try {
            emit(Resource.Loading())
            val response = api.getOwnPosition(courseId, studentId)
            if (response.isSuccessful) {
                val entry = response.body()?.toDomain()
                if (entry != null) {
                    emit(Resource.Success(entry))
                } else {
                    emit(Resource.Error("No se encontró posición propia"))
                }
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error inesperado"))
        } catch (_: IOException) {
            emit(Resource.Error("No se pudo conectar al servidor"))
        }
    }
}
