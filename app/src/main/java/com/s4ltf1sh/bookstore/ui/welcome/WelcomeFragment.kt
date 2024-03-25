package com.s4ltf1sh.bookstore.ui.welcome

import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    override fun setupActions() {
        super.setupActions()

        viewBinding.apply {
            btnLogin.setOnClickListener {
                handleBtnLoginClick()
            }

            btnRegister.setOnClickListener {
                handleBtnRegisterClick()
            }
        }
    }

    private fun handleBtnLoginClick() {
        navigate(R.id.loginFragment)
    }

    private fun handleBtnRegisterClick() {
        navigate(R.id.registerFragment)
    }

    override val backPressCallback: () -> Boolean
        get() = {
            requireActivity().finish()
            true
        }
}