package com.sagrd.mentorly.di

import com.sagrd.mentorly.data.remote.api.CourseMentorlyApi
import com.sagrd.mentorly.data.remote.api.SubmissionMentorlyApi
import com.sagrd.mentorly.data.remote.dto.EnumMoshiAdapters
import com.sagrd.mentorly.data.remote.remotedatasource.SubmissionRemoteDataSource
import com.sagrd.mentorly.data.repository.SubmissionRepositoryImpl
import com.sagrd.mentorly.domain.repository.SubmissionRepository
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(EnumMoshiAdapters())
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideCourseMentorlyApi(moshi: Moshi): CourseMentorlyApi {
        val baseUrl = "https://mentorlyapi-ap2-f8gfgwh3efchgzfn.eastus2-01.azurewebsites.net/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CourseMentorlyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSubmissionApi(moshi: Moshi): SubmissionMentorlyApi {
        val baseUrl = "https://mentorlyapi-ap2-f8gfgwh3efchgzfn.eastus2-01.azurewebsites.net/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(SubmissionMentorlyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSubmissionRepository(remoteDataSource: SubmissionRemoteDataSource): SubmissionRepository {
        return SubmissionRepositoryImpl(remoteDataSource)
    }
}