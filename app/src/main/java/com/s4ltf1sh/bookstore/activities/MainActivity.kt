package com.s4ltf1sh.bookstore.activities

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.activities.BaseActivity
import com.s4ltf1sh.bookstore.data.model.Book
import com.s4ltf1sh.bookstore.databinding.ActivityMainBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.BookDefaultVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initView() {
        super.initView()
        setupNavController()
    }

    private fun setupNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainAct_navHost) as NavHostFragment

        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            Log.d(
                "MainAct",
                "curDestination: $destination"
            )
        }
    }

    fun getBookListener(): BookDefaultVH.BookListener {
        return object : BookDefaultVH.BookListener {
            override fun onBookClicked(item: Book) {
                // Handle book click
                getCurrentParentFragment()?.findNavController()?.navigate(R.id.bookDetailFragment)
            }

            override fun onBookLongClicked(item: Book): Boolean {
                // Handle book long click
                return true
            }
        }
    }

    fun openSearchScreen() {
        getCurrentParentFragment()?.findNavController()?.navigate(R.id.searchFragment)
    }

    private fun getCurrentParentFragment(): Fragment? {
        return navHostFragment.childFragmentManager.fragments[0]
    }
}