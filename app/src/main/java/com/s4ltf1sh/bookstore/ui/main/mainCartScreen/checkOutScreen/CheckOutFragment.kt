package com.s4ltf1sh.bookstore.ui.main.mainCartScreen.checkOutScreen

import androidx.navigation.fragment.findNavController
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentCartCheckOutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckOutFragment :
    BaseFragment<FragmentCartCheckOutBinding>(FragmentCartCheckOutBinding::inflate) {
    override fun initView() {
        super.initView()
        setupHeader()
    }

    private fun setupHeader() {
        viewBinding.header.apply {
            tvTitle.text = getString(R.string.check_out)
            btnNavigation.setOnClickListener {
                popBackStack()
            }
        }
    }

    override fun setupActions() {
        super.setupActions()
        viewBinding.apply {
            btnProcessPayment.setOnClickListener { handleBtnProcessPayClick() }
        }
    }

    private fun handleBtnProcessPayClick() {
        parentFragmentManager.findFragmentById(R.id.mainCart_navHost)?.let {
            findNavController().navigate(R.id.checkOutConfirmFragment)
        }
    }
}