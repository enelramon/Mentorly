package com.sagrd.mentorly.domain.usecase.student

import com.sagrd.mentorly.domain.repository.StudentRepository
import javax.inject.Inject

class GetStudentByIdUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String) = repository.getStudent(id)
}