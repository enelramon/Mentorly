package com.sagrd.mentorly.domain.student.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.student.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getStudents(): Flow<Resource<List<Student>>>
    fun getStudent(id: String): Flow<Resource<Student>>
    fun updateProfile(id: String, email: String, displayName: String): Flow<Resource<Student>>
}