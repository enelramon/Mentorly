package com.sagrd.mentorly.data.remote.api

import com.sagrd.mentorly.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface StudentMentorlyApi {
    @GET("api/Students")
    suspend fun getStudents(): Response<List<UserDto>>

    @POST("api/Students")
    suspend fun createStudent(
        @Body dto: UserDto
    ): Response<UserDto>

    @GET("api/Students/{id}")
    suspend fun getStudent(
        @Path("id") id: String
    ): Response<UserDto>

    @PUT("api/Students/{id}")
    suspend fun updateStudent(
        @Path("id") id: String,
        @Body dto: UserDto
    ): Response<Unit>

    @DELETE("api/Students/{id}")
    suspend fun deleteStudent(
        @Path("id") id: String
    ): Response<Unit>
}