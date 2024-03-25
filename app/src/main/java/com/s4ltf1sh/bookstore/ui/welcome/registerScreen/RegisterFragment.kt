package com.s4ltf1sh.bookstore.ui.welcome.registerScreen

import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun initView() {
        super.initView()
        setupHeader()
    }

    override fun setupActions() {
        super.setupActions()

        setupHeader()
        viewBinding.apply {
            btnRegister.setOnClickListener {
                handleBtnRegisterClick()
            }

            btnSignIn.setOnClickListener {
                handleBtnSignInClick()
            }
        }
    }

    private fun setupHeader() {
        viewBinding.header.apply {
            tvTitle.text = getString(R.string.register)

            btnNavigation.setOnClickListener {
                popBackStack()
            }
        }
    }

    private fun handleBtnRegisterClick() {
        if (popBackStackTo(R.id.welcomeFragment, false).not())
            navigate(R.id.welcomeFragment)
    }

    private fun handleBtnSignInClick() {
        if (popBackStackTo(R.id.loginFragment, false).not())
            navigate(action = R.id.loginFragment)
    }
}