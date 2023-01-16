package ru.anarkh.base

import android.os.Bundle
import androidx.annotation.AnimRes
import androidx.fragment.app.Fragment

sealed class Screen

class FragmentScreen(
    val fragmentClass: Class<out Fragment>,
    val args: Bundle,
    val animations: FragmentAnimations? = null
) : Screen() {

    class FragmentAnimations(
        @AnimRes
        val enterAnimation: Int,
        @AnimRes
        val exitAnimation: Int,
    )
}