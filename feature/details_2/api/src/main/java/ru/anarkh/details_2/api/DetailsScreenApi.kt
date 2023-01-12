package ru.anarkh.details_2.api

import androidx.fragment.app.Fragment


interface DetailsScreenApi {

    /**
     * Should be container, like abstract Screen, but let's have Fragment to simplify
     */
    fun getDetailsScreen(model: DetailsNetModel): Fragment

    fun getDetailsScreen(photo: RoverDetailsPhoto): Fragment
}