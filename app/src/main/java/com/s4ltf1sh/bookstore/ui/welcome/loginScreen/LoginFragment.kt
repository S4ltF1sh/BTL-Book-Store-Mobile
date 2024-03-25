package com.s4ltf1sh.bookstore.ui.welcome.loginScreen

import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.activities.WelcomeActivity
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun initView() {
        super.initView()
        setupHeader()
    }

    override fun setupActions() {
        super.setupActions()

        setupHeader()
        viewBinding.apply {
            btnGetStarted.setOnClickListener {
                handleBtnGetStartedClick()
            }

            btnRegister.setOnClickListener {
                handleBtnRegisterClick()
            }
        }
    }

    private fun setupHeader() {
        viewBinding.header.apply {
            tvTitle.text = getString(R.string.login)

            btnNavigation.setOnClickListener {
                popBackStack()
            }
        }
    }

    private fun handleBtnGetStartedClick() {
        (activity as? WelcomeActivity)?.openMainActivity()
    }

    private fun handleBtnRegisterClick() {
        if (popBackStackTo(R.id.registerFragment, false).not())
            navigate(R.id.registerFragment)
    }
}