package com.sagrd.mentorly.domain.course.usecase

import com.sagrd.mentorly.domain.course.repository.CourseRepository
import javax.inject.Inject

class GetCourseByIdUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(id: String) = repository.getCourse(id)
}