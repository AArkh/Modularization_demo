package ru.anarkh.navigation_2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.anarkh.modularization.core.ui.R
import javax.inject.Inject

class Navigator @Inject constructor(activity: FragmentActivity){

    private val fragmentManager = activity.supportFragmentManager

    /**
     * Here also should be Screen, but let's leave Fragment for now
     */
    fun openScreen(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
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