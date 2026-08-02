package com.sagrd.mentorly.domain.student.usecase

import com.sagrd.mentorly.domain.student.repository.StudentRepository
import javax.inject.Inject

class UpdateStudentUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String, email: String, displayName: String) =
        repository.updateProfile(id, email, displayName)
}