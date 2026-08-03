package com.sagrd.mentorly.data.remote.api

import com.sagrd.mentorly.data.remote.dto.SubmissionDto
import com.sagrd.mentorly.data.remote.dto.SubmitExerciseRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface SubmissionMentorlyApi {
    @GET("api/Submissions")
    suspend fun getSubmissions(
        @Query("enrollmentId") enrollmentId: String? = null,
        @Query("activityId") activityId: String? = null
    ): Response<List<SubmissionDto>>

    @POST("api/Submissions")
    suspend fun submitExercise(
        @Body dto: SubmitExerciseRequestDto
    ): Response<SubmissionDto>

    @GET("api/Submissions/{id}")
    suspend fun getSubmissionDetail(
        @Path("id") id: String
    ): Response<SubmissionDto>

    @PUT("api/Submissions/{id}")
    suspend fun updateSubmission(
        @Path("id") id: String,
        @Body dto: SubmitExerciseRequestDto
    ): Response<Unit>

    @DELETE("api/Submissions/{id}")
    suspend fun deleteSubmission(
        @Path("id") id: String
    ): Response<Unit>
}