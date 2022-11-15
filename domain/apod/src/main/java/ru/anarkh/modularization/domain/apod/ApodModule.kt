package ru.anarkh.modularization.domain.apod

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApodModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApodApi {
        return retrofit.create(ApodApi::class.java)
    }
}