package com.sagrd.mentorly.domain.usecase.submission

import com.sagrd.mentorly.domain.repository.SubmissionRepository
import javax.inject.Inject

class GetSubmissionDetailUseCase @Inject constructor(
    private val repository: SubmissionRepository
) {
    operator fun invoke(id: String) = repository.getSubmissionDetail(id)
}