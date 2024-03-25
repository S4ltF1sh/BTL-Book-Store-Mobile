package com.s4ltf1sh.bookstore.activities

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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
        setupBotNav()
    }

    private fun setupNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainAct_navHost) as NavHostFragment

        navController = navHostFragment.navController
    }

    private fun setupBotNav() {
        viewBinding.mainActBotNav.setupWithNavController(navController)
    }

    fun getBookListener(): BookDefaultVH.BookListener {
        return object : BookDefaultVH.BookListener {
            override fun onBookClicked(item: Book) {
                // Handle book click
            }

            override fun onBookLongClicked(item: Book): Boolean {
                // Handle book long click
                return true
            }
        }
    }
}