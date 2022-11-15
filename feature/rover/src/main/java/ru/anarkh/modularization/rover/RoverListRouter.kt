package ru.anarkh.modularization.rover

import androidx.fragment.app.Fragment
import ru.anarkh.modularization.domain.rover.RoverPhoto

interface RoverListRouter {

    fun createRoverListFragment(): Fragment = RoverFragment()

    fun openRoverList()

    fun openRoverDetails(roverPhoto: RoverPhoto)
}