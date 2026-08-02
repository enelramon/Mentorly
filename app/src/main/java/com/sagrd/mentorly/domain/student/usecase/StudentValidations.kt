package com.sagrd.mentorly.domain.student.usecase

data class StudentValidation(
    val isValid: Boolean,
    val error: String? = null
)

fun validateEmail(email: String): StudentValidation {
    return when {
        email.isBlank() -> StudentValidation(false, "Email requerido")
        !email.contains("@") -> StudentValidation(false, "Debe contener '@'")
        else -> StudentValidation(true)
    }
}

fun validateDisplayName(displayName: String): StudentValidation {
    return when {
        displayName.isBlank() -> StudentValidation(false, "Nombre requerido")
        else -> StudentValidation(true)
    }
}