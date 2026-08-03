package com.sagrd.mentorly.domain.usecase.enrollment

import com.sagrd.mentorly.domain.repository.EnrollmentRepository
import javax.inject.Inject

class GetEnrollmentDetailUseCase @Inject constructor(
    private val repository: EnrollmentRepository
) {
    operator fun invoke(id: String) = repository.getEnrollmentDetail(id)
}