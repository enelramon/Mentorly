package com.sagrd.mentorly.presentation.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.mentorly.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AuthUiState())
    val state = _state.asStateFlow()

    fun onEvent(event: AuthUiEvent) {
        when (event) {
            is AuthUiEvent.SignInWithGoogle -> signIn(event.context)
            is AuthUiEvent.SignOut -> signOut()
        }
    }

    private fun checkSession() {
        authRepository.getCurrentUser()?.let { user ->
            _state.update {
                it.copy(user = user)
            }
        }
    }

    private fun signIn(context: Context) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            val result = authRepository.signInWithGoogle(context)

            result.fold(
                onSuccess = { user ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            user = user
                        )
                    }
                },
                onFailure = { e ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = e.message
                        )
                    }
                }
            )
        }
    }

    private fun signOut() {
        viewModelScope.launch {
            authRepository.signOut()
            _state.update {
                it.copy(user = null)
            }
        }
    }
}