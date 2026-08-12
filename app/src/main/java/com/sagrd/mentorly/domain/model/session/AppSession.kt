package com.sagrd.mentorly.domain.model.session

data class AppSession(
    val studentId: String,
    val name: String,
    val email: String,
    val photoUrl: String? = null
)
