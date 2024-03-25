package com.s4ltf1sh.bookstore.ui.main

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initView() {
        super.initView()
        setupNavController()
        setupBotNav()
    }

    private fun setupNavController() {
        navHostFragment =
            childFragmentManager.findFragmentById(R.id.mainFm_navHost ) as NavHostFragment

        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d(
                "MainFm",
                "curDestination: $destination"
            )
        }
    }

    private fun setupBotNav() {
        viewBinding.mainFmBotNav.setupWithNavController(navController)
    }
}