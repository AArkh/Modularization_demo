package ru.anarkh.navigation_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.anarkh.base.FragmentScreen
import ru.anarkh.modularization.core.ui.R
import javax.inject.Inject

class Navigator @Inject constructor(activity: FragmentActivity) {

    private val fragmentManager = activity.supportFragmentManager

    fun openScreen(fragmentScreen: FragmentScreen) {
        val transaction = fragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragmentScreen.fragmentClass, fragmentScreen.args)

        if (fragmentScreen.animations != null) {
            transaction.setCustomAnimations(
                fragmentScreen.animations!!.enterAnimation,
                fragmentScreen.animations!!.exitAnimation
            )
        }

        transaction.commit()
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