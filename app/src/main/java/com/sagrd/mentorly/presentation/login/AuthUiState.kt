package com.sagrd.mentorly.presentation.login

import com.google.firebase.auth.FirebaseUser

data class AuthUiState (
    val isLoading: Boolean = false,
    val user: FirebaseUser? = null,
    val error: String? = null,
)