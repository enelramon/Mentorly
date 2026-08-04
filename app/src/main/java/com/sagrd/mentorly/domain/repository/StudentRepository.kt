package com.sagrd.mentorly.domain.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.domain.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentRepository {
    fun getStudents(): Flow<Resource<List<Student>>>
    fun getStudent(id: String): Flow<Resource<Student>>
    fun createStudent(student: Student): Flow<Resource<Student>>
    fun updateStudent(student: Student): Flow<Resource<Boolean>>
    fun deleteStudent(id: String): Flow<Resource<Boolean>>
}