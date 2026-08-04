package com.sagrd.mentorly.domain.usecase.submission

import com.sagrd.mentorly.domain.model.Submission
import com.sagrd.mentorly.domain.repository.SubmissionRepository
import javax.inject.Inject

class CreateSubmissionUseCase @Inject constructor(
    private val repository: SubmissionRepository
) {
    operator fun invoke(submission: Submission) = repository.createSubmission(submission)
}