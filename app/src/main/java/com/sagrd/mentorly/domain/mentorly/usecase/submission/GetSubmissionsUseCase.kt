package com.sagrd.mentorly.domain.mentorly.usecase.submission

import com.sagrd.mentorly.domain.mentorly.repository.SubmissionRepository
import javax.inject.Inject

class GetSubmissionsUseCase @Inject constructor(
    private val repository: SubmissionRepository
) {
    operator fun invoke(enrollmentId: String? = null, activityId: String? = null) =
        repository.getSubmissions(enrollmentId, activityId)
}