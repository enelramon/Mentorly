package com.sagrd.mentorly.domain.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    fun getCourses(): Flow<Resource<List<Course>>>

    fun getCourseDetail(
        id: String
    ): Flow<Resource<Course>>

    fun createCourse(
        title: String,
        description: String,
        createdByAdminId: String,
        requiredPeerReviews: Int
    ): Flow<Resource<Course>>

    fun updateCourse(
        id: String,
        title: String,
        description: String,
        requiredPeerReviews: Int
    ): Flow<Resource<Boolean>>

    fun deleteCourse(
        id: String
    ): Flow<Resource<Boolean>>
}