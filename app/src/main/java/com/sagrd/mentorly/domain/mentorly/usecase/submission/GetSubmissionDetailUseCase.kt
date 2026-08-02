package com.sagrd.mentorly.domain.mentorly.usecase.submission

import com.sagrd.mentorly.domain.mentorly.repository.SubmissionRepository
import javax.inject.Inject

class GetSubmissionDetailUseCase @Inject constructor(
    private val repository: SubmissionRepository
) {
    operator fun invoke(id: Int) = repository.getSubmissionDetail(id)
}