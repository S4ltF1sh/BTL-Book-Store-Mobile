package com.s4ltf1sh.bookstore.activities

import android.annotation.SuppressLint
import android.content.Intent
import com.s4ltf1sh.bookstore.base.activities.BaseActivity
import com.s4ltf1sh.bookstore.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    companion object {
        private const val TIME_DELAY_SPLASH = 3000L
    }

    override fun initView() {

    }

    override fun setupActions() {
        viewBinding.apply {
            imgLaunch.postDelayed({
                openMainActivity()
            }, TIME_DELAY_SPLASH)
        }
    }

    private fun openWelcomeActivity() {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}