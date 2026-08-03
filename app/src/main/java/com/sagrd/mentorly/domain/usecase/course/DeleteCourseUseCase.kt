package com.sagrd.mentorly.domain.usecase.course

import com.sagrd.mentorly.domain.repository.CourseRepository
import javax.inject.Inject

class DeleteCourseUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke(id: String) = repository.deleteCourse(id)
}