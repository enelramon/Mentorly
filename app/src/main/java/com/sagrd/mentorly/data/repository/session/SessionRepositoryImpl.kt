package com.sagrd.mentorly.data.repository.session

import com.sagrd.mentorly.domain.model.session.AppSession
import com.sagrd.mentorly.domain.repository.session.SessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor() : SessionRepository {
    override fun getSession(): Flow<AppSession?> = flowOf(
        AppSession(
            studentId = "current_student_id",
            name = "Estudiante Actual",
            email = "student@example.com"
        )
    )
}
