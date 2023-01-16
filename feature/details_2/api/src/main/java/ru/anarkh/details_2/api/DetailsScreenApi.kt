package ru.anarkh.details_2.api

import ru.anarkh.base.FragmentScreen


interface DetailsScreenApi {

    /**
     * Should be container, like abstract Screen, but let's have Fragment to simplify
     */
    fun getDetailsScreen(model: DetailsNetModel): FragmentScreen

    fun getDetailsScreen(photo: RoverDetailsPhoto): FragmentScreen
}