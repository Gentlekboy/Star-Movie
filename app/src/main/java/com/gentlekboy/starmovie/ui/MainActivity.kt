package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bottomNavigationBar.setupWithNavController(navController)

        lifecycleScope.launch {
            val flow = navController.currentBackStackEntryFlow
            flow.collectLatest {
                Log.d("GKB", "==================")
                Log.d("GKB", "destination -> ${it.destination} ")
                Log.d("GKB", "currentBackStackEntryFlow -> $it ")
            }
        }

        // Set the bottom navigation in various fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.ticketFragment -> showBottomNav()
                R.id.notificationFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    /**
     * Toggle on visibility of the navigation bar
     */
    private fun showBottomNav() {
        binding.bottomNavigationBar.visibility = View.VISIBLE
    }

    /**
     * Toggle off visibility of the navigation bar
     */
    private fun hideBottomNav() {
        binding.bottomNavigationBar.visibility = View.GONE
    }
}