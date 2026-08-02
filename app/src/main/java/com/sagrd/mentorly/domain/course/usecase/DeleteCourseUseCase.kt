package com.sagrd.mentorly.domain.course.usecase

import com.sagrd.mentorly.domain.course.repository.CourseRepository
import javax.inject.Inject

class DeleteCourseUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(id: String) = repository.deleteCourse(id)
}