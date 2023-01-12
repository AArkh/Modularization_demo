package ru.anarkh.modularization.demo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import ru.anarkh.modularization.apod.ApodListRouter
import ru.anarkh.modularization.apod.GodRouter
import ru.anarkh.modularization.rover.RoverListRouter

/**
 * Binding COULD be inside of :feature:details-impl module, BUT AndroidStudio dagger plugin failing
 * to resolve it, so no navigation would be available =(
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class DetailsModule {

    @Binds
    abstract fun bindApodListRouter(impl: GodRouter): ApodListRouter

    @Binds
    abstract fun bindRoverListRouter(impl: GodRouter): RoverListRouter
}