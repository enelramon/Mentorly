package com.sagrd.mentorly.data.remote.api

import com.sagrd.mentorly.data.remote.dto.CreateEnrollmentDto
import com.sagrd.mentorly.data.remote.dto.EnrollmentDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EnrollmentMentorlyApi {
    @GET("api/Enrollments")
    suspend fun getEnrollments(): Response<List<EnrollmentDto>>

    @POST("api/Enrollments")
    suspend fun createEnrollment(
        @Body dto: CreateEnrollmentDto
    ): Response<EnrollmentDto>

    @GET("api/Enrollments/{id}")
    suspend fun getEnrollmentDetail(
        @Path("id") id: String
    ): Response<EnrollmentDto>
}