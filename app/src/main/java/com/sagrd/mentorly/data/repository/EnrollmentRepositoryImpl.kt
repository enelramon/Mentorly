package com.sagrd.mentorly.data.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.dto.CreateEnrollmentDto
import com.sagrd.mentorly.data.remote.remotedatasource.EnrollmentRemoteDataSource
import com.sagrd.mentorly.domain.model.Enrollment
import com.sagrd.mentorly.domain.repository.EnrollmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EnrollmentRepositoryImpl @Inject constructor(
    private val remoteDataSource: EnrollmentRemoteDataSource
) : EnrollmentRepository {
    override fun getEnrollments(
        studentId: String?,
        courseId: String?
    ): Flow<Resource<List<Enrollment>>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getEnrollments()
            .onSuccess { dto ->
                emit(Resource.Success(dto.map { it.toDomain() }))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido"))
            }
    }

    override fun getEnrollmentDetail(id: String): Flow<Resource<Enrollment>> = flow {
        emit(Resource.Loading())
        remoteDataSource.getEnrollmentDetail(id)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun createEnrollment(enrollment: Enrollment): Flow<Resource<Enrollment>> = flow {
        emit(Resource.Loading())
        val dto = CreateEnrollmentDto(
            studentId = enrollment.studentId,
            courseId = enrollment.courseId,
            attemptNumber = enrollment.attemptNumber
        )

        remoteDataSource.createEnrollment(dto)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido"))
            }
    }
}