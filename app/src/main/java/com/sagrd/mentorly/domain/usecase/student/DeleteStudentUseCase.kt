package com.sagrd.mentorly.domain.usecase.student

import com.sagrd.mentorly.domain.repository.StudentRepository
import jakarta.inject.Inject

class DeleteStudentUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String) = repository.deleteStudent(id)
}