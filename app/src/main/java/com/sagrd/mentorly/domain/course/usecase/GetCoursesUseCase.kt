package com.sagrd.mentorly.domain.course.usecase

import com.sagrd.mentorly.domain.course.repository.CourseRepository
import javax.inject.Inject

class GetCoursesUseCase @Inject constructor(
    private val repository: CourseRepository
) {
    operator fun invoke() = repository.getCourses()
}