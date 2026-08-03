package com.sagrd.mentorly.presentation.login

import android.content.Context

interface AuthUiEvent {
    data class SignInWithGoogle(val context: Context): AuthUiEvent
    data object SignOut: AuthUiEvent
}