package com.sagrd.mentorly.domain.student.usecase

import com.sagrd.mentorly.domain.student.repository.StudentRepository
import javax.inject.Inject

class GetStudentsUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke() = repository.getStudents()
}