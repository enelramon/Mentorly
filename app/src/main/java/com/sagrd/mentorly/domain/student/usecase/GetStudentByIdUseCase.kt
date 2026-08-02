package com.sagrd.mentorly.domain.student.usecase

import com.sagrd.mentorly.domain.student.repository.StudentRepository
import javax.inject.Inject

class GetStudentByIdUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String) = repository.getStudent(id)
}