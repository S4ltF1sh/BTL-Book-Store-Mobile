package com.s4ltf1sh.bookstore.ui.main.mainCartScreen.checkOutScreen

import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.constants.Strings
import com.s4ltf1sh.bookstore.databinding.FragmentCartCheckOutConfirmBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckOutConfirmFragment :
    BaseFragment<FragmentCartCheckOutConfirmBinding>(FragmentCartCheckOutConfirmBinding::inflate) {
    override fun initView() {
        super.initView()
        setupHeader()
    }

    private fun setupHeader() {
        viewBinding.header.apply {
            tvTitle.text = Strings.EMPTY
            btnNavigation.setOnClickListener {
                popBackStackTo(R.id.cartFragment)
            }
        }
    }
}