package ru.anarkh.modularization.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ru.anarkh.modularization.apod.GodRouter
import ru.anarkh.navigation_2.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var god: GodRouter

    @Inject
    lateinit var navigator: Navigator

    private var currentScreenId = R.id.apod_nav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<BottomNavigationView>(R.id.main_bottom_navigation).setupNav()
        if (supportFragmentManager.fragments.isEmpty()) {
            god.openApodList()
        }
    }

    override fun onBackPressed() {
        if (!god.onBackPressed() && !navigator.onBackPressed()) {
            super.onBackPressed()
        }
    }

    private fun BottomNavigationView.setupNav() {
        selectedItemId = currentScreenId
        setOnItemSelectedListener {
            when(it.itemId) {
                currentScreenId -> return@setOnItemSelectedListener false
                R.id.apod_nav -> {
                    currentScreenId = R.id.apod_nav
                    god.openApodList()
                }
                R.id.rover_nav -> {
                    currentScreenId = R.id.rover_nav
                    god.openRoverList()
                }
                else -> throw IllegalArgumentException()
            }
            return@setOnItemSelectedListener true
        }
    }
}