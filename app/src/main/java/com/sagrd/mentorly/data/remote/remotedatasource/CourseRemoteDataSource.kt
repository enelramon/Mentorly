package com.sagrd.mentorly.data.remote.remotedatasource

import com.sagrd.mentorly.data.remote.api.CourseMentorlyApi
import com.sagrd.mentorly.data.remote.dto.ActivityDto
import com.sagrd.mentorly.data.remote.dto.CourseDto
import com.sagrd.mentorly.data.remote.dto.CourseImageDto
import com.sagrd.mentorly.data.remote.dto.CourseUnitDto
import com.sagrd.mentorly.data.remote.dto.CreateActivityDto
import com.sagrd.mentorly.data.remote.dto.CreateCourseDto
import com.sagrd.mentorly.data.remote.dto.CreateCourseImageDto
import com.sagrd.mentorly.data.remote.dto.CreateThemeDto
import com.sagrd.mentorly.data.remote.dto.CreateUnitDto
import com.sagrd.mentorly.data.remote.dto.ThemeDto
import com.sagrd.mentorly.data.remote.dto.UpdateCourseDto
import retrofit2.HttpException
import javax.inject.Inject

class CourseRemoteDataSource @Inject constructor(
    private val api: CourseMentorlyApi
) {
    suspend fun getCourses(): Result<List<CourseDto>> {
        return try {
            val response = api.getCourses()
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

    suspend fun getCourseDetail(id: String): Result<CourseDto> {
        return try {
            val response = api.getCourseDetail(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun createCourse(dto: CreateCourseDto): Result<CourseDto> {
        return try {
            val response = api.createCourse(dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error del servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun updateCourse(id: String, dto: UpdateCourseDto): Result<Unit> {
        return try {
            val response = api.updateCourse(id, dto)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(Unit)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun deleteCourse(id: String): Result<Unit> {
        return try {
            val response = api.deleteCourse(id)
            if (!response.isSuccessful) {
                Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                Result.success(Unit)
            }
        } catch (e: HttpException) {
            Result.failure(Exception("Error de servidor", e))
        } catch (e: Exception) {
            Result.failure(Exception("Error desconocido", e))
        }
    }

    suspend fun addUnit(courseId: String, dto: CreateUnitDto): Result<CourseUnitDto> {
        return try {
            val response = api.addUnit(courseId, dto)
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

    suspend fun addTheme(unitId: String, dto: CreateThemeDto): Result<ThemeDto> {
        return try {
            val response = api.addTheme(unitId, dto)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red: ${response.code()}"))
            } else {
                return Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error del servidor: ", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido: ", e))
        }
    }

    suspend fun addActivity(courseId: String, dto: CreateActivityDto): Result<ActivityDto> {
        return try {
            val response = api.addActivity(courseId, dto)
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

    suspend fun addCourseImage(courseId: String, dto: CreateCourseImageDto): Result<CourseImageDto> {
        return try {
            val response = api.addCourseImage(courseId, dto)
            if (!response.isSuccessful) {
                return Result.failure(Exception("Error de red ${response.code()}"))
            } else {
                return Result.success(response.body()!!)
            }
        } catch (e: HttpException) {
            return Result.failure(Exception("Error del servidor: ", e))
        } catch (e: Exception) {
            return Result.failure(Exception("Error desconocido", e))
        }
    }
}