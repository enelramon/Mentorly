package com.sagrd.mentorly.data.remote.api

import com.sagrd.mentorly.data.remote.dto.CreatePeerReviewRequestDto
import com.sagrd.mentorly.data.remote.dto.PeerReviewDto
import com.sagrd.mentorly.data.remote.dto.PeerReviewResultDto
import com.sagrd.mentorly.data.remote.dto.UpdatePeerReviewDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PeerReviewMentorlyApi {
    @GET("api/PeerReviews")
    suspend fun getPeerReviews(): Response<List<PeerReviewDto>>

    @POST("api/PeerReviews")
    suspend fun submitReview(
        @Body dto: CreatePeerReviewRequestDto
    ): Response<PeerReviewResultDto>

    @GET("api/PeerReviews/{id}")
    suspend fun getPeerReview(
        @Path("id") id: String
    ): Response<PeerReviewDto>

    @PUT("api/PeerReviews/{id}")
    suspend fun updatePeerReview(
        @Path("id") id: String,
        @Body dto: UpdatePeerReviewDto
    ): Response<Unit>

    @DELETE("api/PeerReviews/{id}")
    suspend fun deletePeerReview(
        @Path("id") id: String
    ): Response<Unit>
}