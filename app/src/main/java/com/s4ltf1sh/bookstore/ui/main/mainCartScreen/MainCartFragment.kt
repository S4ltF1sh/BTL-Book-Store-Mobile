package com.s4ltf1sh.bookstore.ui.main.mainCartScreen

import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentMainCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainCartFragment : BaseFragment<FragmentMainCartBinding>(FragmentMainCartBinding::inflate) {
    override val backPressCallback: () -> Boolean
        get() = {
            requireActivity().finish()
            true
        }
}