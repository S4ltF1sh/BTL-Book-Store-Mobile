package com.s4ltf1sh.bookstore.activities

import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.activities.BaseActivity
import com.s4ltf1sh.bookstore.databinding.ActivityWelcomeBinding

class WelcomeActivity : BaseActivity<ActivityWelcomeBinding>(ActivityWelcomeBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun initView() {
        super.initView()
        setupNavController()
    }

    private fun setupNavController() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.welcomeAct_navHost) as NavHostFragment

        navController = navHostFragment.navController
    }

    fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}