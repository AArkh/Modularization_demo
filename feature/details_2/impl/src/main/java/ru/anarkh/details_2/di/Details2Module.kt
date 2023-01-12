package ru.anarkh.details_2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.anarkh.details_2.api.DetailsScreenApi
import ru.anarkh.details_2.impl.DetailsScreenImpl

/**
 * Every module will have small DI container with dependencies only for this module
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class Details2Module {

    @Binds
    abstract fun bindDetailsScreenApi(impl: DetailsScreenImpl): DetailsScreenApi
}