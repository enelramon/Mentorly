package com.sagrd.mentorly.domain.course.usecase

import com.sagrd.mentorly.domain.course.repository.CourseRepository
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