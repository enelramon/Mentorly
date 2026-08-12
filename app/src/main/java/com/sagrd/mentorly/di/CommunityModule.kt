package com.sagrd.mentorly.di

import com.sagrd.mentorly.data.remote.api.CourseCommunityApi
import com.sagrd.mentorly.data.repository.community.CourseCommunityRepositoryImpl
import com.sagrd.mentorly.data.repository.session.SessionRepositoryImpl
import com.sagrd.mentorly.domain.repository.community.CourseCommunityRepository
import com.sagrd.mentorly.domain.repository.session.SessionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommunityModule {

    @Provides
    @Singleton
    fun provideCourseCommunityApi(retrofit: Retrofit): CourseCommunityApi {
        return retrofit.create(CourseCommunityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCourseCommunityRepository(api: CourseCommunityApi): CourseCommunityRepository {
        return CourseCommunityRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSessionRepository(): SessionRepository {
        return SessionRepositoryImpl()
    }
}
