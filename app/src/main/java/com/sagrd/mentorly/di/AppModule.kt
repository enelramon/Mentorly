package com.sagrd.mentorly.di

import com.sagrd.mentorly.data.remote.MentorlyApi
import com.sagrd.mentorly.domain.mentorly.repository.EnrollmentRepository
import com.sagrd.mentorly.domain.mentorly.repository.SubmissionRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideMentorlyApi(moshi: Moshi): MentorlyApi {
        val baseUrl = ""
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MentorlyApi::class.java)
    }

    /*
    @Provides
    @Singleton
    fun provideEnrollmentRepository(api: MentorlyApi): EnrollmentRepository {
        return EnrollmentRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSubmissionRepository(api: MentorlyApi): SubmissionRepository {
        return SubmissionRepositoryImpl(api)
    }
    */
}