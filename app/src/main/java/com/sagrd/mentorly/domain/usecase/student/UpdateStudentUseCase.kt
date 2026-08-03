package com.sagrd.mentorly.domain.usecase.student

import com.sagrd.mentorly.domain.repository.StudentRepository
import javax.inject.Inject

class UpdateStudentUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String, email: String, displayName: String) =
        repository.updateProfile(id, email, displayName)
}