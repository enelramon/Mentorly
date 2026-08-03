package com.sagrd.mentorly.domain.mentorly.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.mentorly.model.Enrollment
import kotlinx.coroutines.flow.Flow

interface EnrollmentRepository {
    fun getEnrollments(
        studentId: String? = null,
        courseId: String? = null
    ): Flow<Resource<List<Enrollment>>>
    fun getEnrollmentDetail(id: String): Flow<Resource<Enrollment>>
    fun saveEnrollment(enrollment: Enrollment): Flow<Resource<Enrollment>>
}