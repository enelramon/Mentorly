package com.sagrd.mentorly.domain.usecase.student

import com.sagrd.mentorly.domain.repository.StudentRepository
import javax.inject.Inject

class UpsertStudentUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(id: String?, googleUserId: String, email: String, displayName: String) =
        if (id.isNullOrBlank())
            repository.createStudent(googleUserId, email, displayName)
        else
            repository.updateStudent(id, email, displayName)
}