package com.example.pifsportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        val bottomAppBar : BottomAppBar = findViewById(R.id.bottomAppBar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigation.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    bottomNavigation.visibility = View.GONE
                    fab.visibility = View.GONE
                    bottomAppBar.visibility = View.GONE
                }
                R.id.loginFragment -> {
                    bottomNavigation.visibility = View.GONE
                    fab.visibility = View.GONE
                    bottomAppBar.visibility = View.GONE

                }
                else -> {
                    bottomNavigation.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE
                    bottomAppBar.visibility = View.VISIBLE
                }
            }

            when (destination.id) {
                R.id.playFragment -> {
                    fab.setOnClickListener { view ->
                        navController.navigate(R.id.action_playFragment_to_createMatchFragment)
                    }
                }
                R.id.profileFragment -> {
                    fab.setOnClickListener { view ->
                        navController.navigate(R.id.action_profileFragment_to_createMatchFragment)
                    }
                }
            }
        }
    }
}