package com.sagrd.mentorly.data.remote.api

import com.sagrd.mentorly.data.remote.dto.CourseDto
import com.sagrd.mentorly.data.remote.dto.CreateCourseDto
import com.sagrd.mentorly.data.remote.dto.UpdateCourseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CourseMentorlyApi {
    @GET("api/Courses")
    suspend fun getCourses(
        @Query("publishedOnly") publishedOnly: Boolean
    ): Response<List<CourseDto>>

    @GET("api/Courses/{id}")
    suspend fun getCourseDetail(
        @Path("id") id: String
    ): Response<CourseDto>

    @POST("api/Courses")
    suspend fun createCourse(
        @Query("adminId") adminId: String,
        @Body dto: CreateCourseDto
    ): Response<CourseDto>

    @PUT("api/Courses/{id}")
    suspend fun updateCourse(
        @Path("id") id: String,
        @Body dto: UpdateCourseDto
    ): Response<Unit>

    @DELETE("api/Courses/{id}")
    suspend fun deleteCourse(
        @Path("id") id: String
    ): Response<Unit>
}