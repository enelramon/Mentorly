package com.sagrd.mentorly.data.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.dto.CreateCourseDto
import com.sagrd.mentorly.data.remote.dto.UpdateCourseDto
import com.sagrd.mentorly.data.remote.remotedatasource.CourseRemoteDataSource
import com.sagrd.mentorly.domain.model.Course
import com.sagrd.mentorly.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val remoteDataSource: CourseRemoteDataSource
) : CourseRepository {
    override fun getCourses(publishedOnly: Boolean): Flow<Resource<List<Course>>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getCourses(publishedOnly)
            .onSuccess { dto ->
                emit(Resource.Success(dto.map { it.toDomain() }))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun getCourseDetail(id: String): Flow<Resource<Course>> = flow{
        emit(Resource.Loading())
        remoteDataSource.getCourseDetail(id)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun createCourse(
        title: String,
        description: String,
        createdByAdminId: String,
        requiredPeerReviews: Int
    ): Flow<Resource<Course>> = flow {
        emit(Resource.Loading())
        val dto = CreateCourseDto(
            title = title,
            description = description,
            createdByAdminId = createdByAdminId,
            requiredPeerReviews = requiredPeerReviews
        )

        remoteDataSource.createCourse(dto)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun updateCourse(
        id: String,
        title: String,
        description: String,
        requiredPeerReviews: Int
    ): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())

        val dto = UpdateCourseDto(
            title = title,
            description = description,
            requiredPeerReviews = requiredPeerReviews
        )

        remoteDataSource.updateCourse(id, dto)
            .onSuccess { emit(Resource.Success(true)) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido.")) }
    }

    override fun deleteCourse(id: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        remoteDataSource.deleteCourse(id)
            .onSuccess { emit(Resource.Success(true)) }
            .onFailure { emit(Resource.Error(it.message ?: "Error desconocido.")) }
    }
}