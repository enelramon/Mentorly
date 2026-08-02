package com.sagrd.mentorly.domain.mentorly.usecase.enrollment

import com.sagrd.mentorly.domain.mentorly.model.Enrollment
import com.sagrd.mentorly.domain.mentorly.repository.EnrollmentRepository
import javax.inject.Inject

class SaveEnrollmentUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(enrollment: Enrollment) = repository.saveEnrollment(enrollment)
}