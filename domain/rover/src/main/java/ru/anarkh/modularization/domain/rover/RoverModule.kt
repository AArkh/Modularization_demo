package ru.anarkh.modularization.domain.rover

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoverModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): RoverApi {
        return retrofit.create(RoverApi::class.java)
    }
}