package com.sagrd.mentorly.domain.usecase.enrollment

import com.sagrd.mentorly.domain.model.Enrollment
import com.sagrd.mentorly.domain.repository.EnrollmentRepository
import javax.inject.Inject

class CreateEnrollmentUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(enrollment: Enrollment) = repository.createEnrollment(enrollment)
}