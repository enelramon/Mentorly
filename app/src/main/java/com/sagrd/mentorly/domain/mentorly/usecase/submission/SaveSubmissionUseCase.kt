package com.sagrd.mentorly.domain.mentorly.usecase.submission

import com.sagrd.mentorly.domain.mentorly.model.Submission
import com.sagrd.mentorly.domain.mentorly.repository.SubmissionRepository
import javax.inject.Inject

class SaveSubmissionUseCase @Inject constructor(
    private val repository: SubmissionRepository
) {
    operator fun invoke(submission: Submission) = repository.saveSubmission(submission)
}