package com.sagrd.mentorly.domain.mentorly.usecase.enrollment

import com.sagrd.mentorly.domain.mentorly.repository.EnrollmentRepository
import javax.inject.Inject

class GetEnrollmentsUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(studentId: String? = null, courseId: String? = null) =
        repository.getEnrollments(studentId, courseId)
}