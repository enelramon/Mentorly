package com.sagrd.mentorly.data.repository

import com.sagrd.mentorly.data.remote.Resource
import com.sagrd.mentorly.data.remote.dto.CreateSubmissionDto
import com.sagrd.mentorly.data.remote.dto.UpdateSubmissionDto
import com.sagrd.mentorly.data.remote.remotedatasource.SubmissionRemoteDataSource
import com.sagrd.mentorly.domain.enum.SubmissionStatus
import com.sagrd.mentorly.domain.model.Submission
import com.sagrd.mentorly.domain.repository.SubmissionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.OffsetDateTime
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
        result.fold(
            onSuccess = { dtoList ->
                val submissions = dtoList.map { dto ->
                    Submission(
                        id = dto.id,
                        enrollmentId = dto.enrollmentId,
                        activityId = dto.activityId,
                        evidenceUrl = dto.evidenceUrl,
                        status = SubmissionStatus.fromValue(dto.status),
                        submittedAt = try { OffsetDateTime.parse(dto.submittedAt) } catch (e: Exception) { OffsetDateTime.now() },
                        reviewedAt = dto.reviewedAt?.let {
                            try { OffsetDateTime.parse(it) } catch (e: Exception) { null }
                        }
                    )
                }
                emit(Resource.Success(submissions))
            },
            onFailure = { error ->
                emit(Resource.Error(error.message ?: "Error desconocido"))
            }
        )
    }

    override fun getSubmissionDetail(id: String): Flow<Resource<Submission>> = flow {
        emit(Resource.Loading())
        val result = remoteDataSource.getSubmissionDetail(id)
        result.fold(
            onSuccess = { dto ->
                val submission = Submission(
                    id = dto.id,
                    enrollmentId = dto.enrollmentId,
                    activityId = dto.activityId,
                    evidenceUrl = dto.evidenceUrl,
                    status = SubmissionStatus.fromValue(dto.status),
                    submittedAt = try { OffsetDateTime.parse(dto.submittedAt) } catch (e: Exception) { OffsetDateTime.now() },
                    reviewedAt = dto.reviewedAt?.let {
                        try { OffsetDateTime.parse(it) } catch (e: Exception) { null }
                    }
                )
                emit(Resource.Success(submission))
            },
            onFailure = { error ->
                emit(Resource.Error(error.message ?: "Error desconocido"))
            }
        )
    }

    override fun saveSubmission(submission: Submission): Flow<Resource<Submission>> = flow {
        emit(Resource.Loading())
        val requestDto = CreateSubmissionDto(
            enrollmentId = submission.enrollmentId,
            activityId = submission.activityId,
            evidenceUrl = submission.evidenceUrl
        )
        val result = remoteDataSource.submitExercise(requestDto)
        result.fold(
            onSuccess = { dto ->
                val savedSubmission = Submission(
                    id = dto.id,
                    enrollmentId = dto.enrollmentId,
                    activityId = dto.activityId,
                    evidenceUrl = dto.evidenceUrl,
                    status = SubmissionStatus.fromValue(dto.status),
                    submittedAt = try { OffsetDateTime.parse(dto.submittedAt) } catch (e: Exception) { OffsetDateTime.now() },
                    reviewedAt = dto.reviewedAt?.let {
                        try { OffsetDateTime.parse(it) } catch (e: Exception) { null }
                    }
                )
                emit(Resource.Success(savedSubmission))
            },
            onFailure = { error ->
                emit(Resource.Error(error.message ?: "Error desconocido"))
            }
        )
    }

    override fun updateSubmission(id: String, activityId: String, evidenceUrl: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val requestDto = UpdateSubmissionDto(evidenceUrl = evidenceUrl)
        val result = remoteDataSource.updateSubmission(id, requestDto)
        result.fold(
            onSuccess = { emit(Resource.Success(true)) },
            onFailure = { error -> emit(Resource.Error(error.message ?: "Error al actualizar")) }
        )
    }

    override fun deleteSubmission(id: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val result = remoteDataSource.deleteSubmission(id)
        result.fold(
            onSuccess = { emit(Resource.Success(true)) },
            onFailure = { error -> emit(Resource.Error(error.message ?: "Error al eliminar")) }
        )
    }
}