package com.sagrd.mentorly.domain.usecase.enrollment

import com.sagrd.mentorly.domain.repository.EnrollmentRepository
import javax.inject.Inject

class GetEnrollmentsUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(studentId: String? = null, courseId: String? = null) =
        repository.getEnrollments(studentId, courseId)
}