package ru.anarkh.modularization.apod

import androidx.fragment.app.Fragment
import ru.anarkh.modularization.domain.apod.ApodNetModel

interface ApodListRouter {

    fun createApodListFragment(): Fragment = ApodFragment()

    fun openApodList()

    fun openApodDetails(apodNetModel: ApodNetModel)
}