package com.sagrd.mentorly.domain.usecase.course

import com.sagrd.mentorly.domain.repository.CourseRepository
import javax.inject.Inject

class UpsertCourseUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(
        id: String?,
        title: String,
        description: String,
        requiredPeerReviews: Int
    ) =
        if (id.isNullOrBlank())
            repository.createCourse(title, description, requiredPeerReviews)
        else
            repository.updateCourse(id, title, description, requiredPeerReviews)
}