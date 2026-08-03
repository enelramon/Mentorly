package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.MentorlyApi
import com.sagrd.mentorly.data.remote.dto.CourseDto
import com.sagrd.mentorly.data.remote.dto.CreateCourseDto
import com.sagrd.mentorly.data.remote.dto.UpdateCourseDto
import retrofit2.HttpException
import javax.inject.Inject

class CourseRemoteDataSource @Inject constructor(
    private val api: MentorlyApi
) {
    suspend fun getCourses(): Result<List<CourseDto>> {
        try {
            val response = api.getCourses()
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error del servidor: ", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido: ", e))
        }
    }

    suspend fun getCourseDetail(id: String): Result<CourseDto> {
        try {
            val response = api.getCourseDetail(id)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun createCourse(dto: CreateCourseDto): Result<CourseDto> {
        try {
            val response = api.createCourse(dto)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun updateCourse(id: String, dto: UpdateCourseDto): Result<Unit> {
        try {
            val response = api.updateCourse(id, dto)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(Unit)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun deleteCourse(id: String): Result<Unit> {
        try {
            val response = api.deleteCourse(id)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(Unit)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }

}