package com.sagrd.mentorly.domain.usecase.student

import com.sagrd.mentorly.domain.model.Student
import com.sagrd.mentorly.domain.repository.StudentRepository
import javax.inject.Inject

class UpsertStudentUseCase @Inject constructor(
    private val repository: StudentRepository
) {
    operator fun invoke(student: Student) =
        if (student.id.isBlank())
            repository.createStudent(student)
        else
            repository.updateStudent(student)
}