package com.sagrd.mentorly.domain.mentorly.usecase.enrollment

import com.sagrd.mentorly.domain.mentorly.repository.EnrollmentRepository
import javax.inject.Inject

class GetEnrollmentDetailUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(id: String) = repository.getEnrollmentDetail(id)
}