package com.sagrd.mentorly.data.remote.api

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

    @POST("api/Courses/{id}/units")
    suspend fun addUnit(
        @Path("id") courseId: String,
        @Body dto: CreateUnitDto
    ): Response<CourseUnitDto>

    @POST("api/Courses/units/{unitId}/themes")
    suspend fun addTheme(
        @Path("unitId") unitId: String,
        @Body dto: CreateThemeDto
    ): Response<ThemeDto>

    @POST("api/Courses/themes/{themeId}/activities")
    suspend fun addActivity(
        @Path("themeId") themeId: String,
        @Body dto: CreateActivityDto
    ): Response<ActivityDto>

    @POST("api/Courses/{id}/images")
    suspend fun addCourseImage(
        @Path("id") id: String,
        @Body dto: CreateCourseImageDto
    ): Response<CourseImageDto>
}