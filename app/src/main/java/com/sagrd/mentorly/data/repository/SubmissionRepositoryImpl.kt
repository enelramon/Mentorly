package com.sagrd.mentorly.data.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.dto.CreateSubmissionDto
import com.sagrd.mentorly.data.remote.dto.UpdateSubmissionDto
import com.sagrd.mentorly.data.remote.remotedatasource.SubmissionRemoteDataSource
import com.sagrd.mentorly.domain.model.Submission
import com.sagrd.mentorly.domain.repository.SubmissionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SubmissionRepositoryImpl @Inject constructor(
    private val remoteDataSource: SubmissionRemoteDataSource
) : SubmissionRepository {

    override fun getSubmissions(
        enrollmentId: String?,
        activityId: String?
    ): Flow<Resource<List<Submission>>> = flow {
        emit(Resource.Loading())
        val result = remoteDataSource.getSubmissions(enrollmentId, activityId)
            .onSuccess { dto ->
                emit(Resource.Success(dto.map { it.toDomain() }))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun getSubmissionDetail(id: String): Flow<Resource<Submission>> = flow {
        emit(Resource.Loading())
        val result = remoteDataSource.getSubmissionDetail(id)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido"))
            }
    }

    override fun createSubmission(submission: Submission): Flow<Resource<Submission>> = flow {
        emit(Resource.Loading())

        val dto = CreateSubmissionDto(
            enrollmentId = submission.enrollmentId,
            activityId = submission.activityId,
            evidenceUrl = submission.evidenceUrl
        )

        remoteDataSource.createSubmission(dto)
            .onSuccess {
                emit(Resource.Success(it.toDomain()))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido"))
            }
    }

    override fun updateSubmission(id: String, evidenceUrl: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())

        val dto = UpdateSubmissionDto(
            evidenceUrl = evidenceUrl
        )

        remoteDataSource.updateSubmission(id, dto)
            .onSuccess {
                emit(Resource.Success(true))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }

    override fun deleteSubmission(id: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        remoteDataSource.deleteSubmission(id)
            .onSuccess {
                emit(Resource.Success(true))
            }
            .onFailure {
                emit(Resource.Error(it.message ?: "Error desconocido."))
            }
    }
}