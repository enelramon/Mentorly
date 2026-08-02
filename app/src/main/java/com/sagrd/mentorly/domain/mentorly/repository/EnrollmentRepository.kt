package com.sagrd.mentorly.domain.mentorly.repository

import com.sagrd.mentorly.data.mentorly.Resource
import com.sagrd.mentorly.domain.mentorly.model.Enrollment
import kotlinx.coroutines.flow.Flow

interface EnrollmentRepository {
    fun getEnrollments(
        studentId: Int? = null,
        courseId: Int? = null
    ): Flow<Resource<List<Enrollment>>>
    fun getEnrollmentDetail(id: Int): Flow<Resource<Enrollment>>
    fun saveEnrollment(enrollment: Enrollment): Flow<Resource<Enrollment>>
}