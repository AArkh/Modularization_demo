package ru.anarkh.modularization.apod

import androidx.fragment.app.FragmentActivity
import ru.anarkh.modularization.core.ui.R
import ru.anarkh.modularization.domain.apod.ApodNetModel
import ru.anarkh.modularization.domain.rover.RoverPhoto
import ru.anarkh.modularization.rover.RoverListRouter
import javax.inject.Inject

class GodRouter @Inject constructor(
    activity: FragmentActivity
) : ApodListRouter, RoverListRouter {

    private val fragmentManager = activity.supportFragmentManager

    override fun openApodList() {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, createApodListFragment())
            .commit()
    }

    override fun openRoverList() {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, createRoverListFragment())
            .commit()
    }

    fun onBackPressed(): Boolean {
        val fragments = fragmentManager.fragments.filterNot {
            // Lol, Glide, fucking really?
            it::class.java.simpleName.contains("SupportRequestManagerFragment")
        }
        if (fragments.size > 1) {
            val activeFragment = fragments.last()
            fragmentManager.beginTransaction().remove(activeFragment).commit()
            return true
        }
        return false
    }
}