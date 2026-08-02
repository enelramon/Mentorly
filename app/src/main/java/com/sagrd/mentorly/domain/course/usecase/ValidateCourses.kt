package com.sagrd.mentorly.domain.course.usecase

data class CourseValidation(
    val isValid: Boolean,
    val error: String? = null
)

fun validateTitle(title: String): CourseValidation {
    return when {
        title.isBlank() -> CourseValidation(false, "Título requerido")
        else -> CourseValidation(true)
    }
}

fun validateRequiredPeerReviews(requiredPeerReviews: String): CourseValidation {
    val valor = requiredPeerReviews.trim().toIntOrNull()
    return when {
        requiredPeerReviews.isBlank() -> CourseValidation(false, "Cuota de peer reviews requerida")
        valor == null -> CourseValidation(false, "Debe ser un número entero válido")
        valor <= 0 -> CourseValidation(false, "La cuota (N) debe ser mayor que cero")
        else -> CourseValidation(true)
    }
}