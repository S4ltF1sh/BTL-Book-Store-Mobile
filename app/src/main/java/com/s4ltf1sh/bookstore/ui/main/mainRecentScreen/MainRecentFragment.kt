package com.s4ltf1sh.bookstore.ui.main.mainRecentScreen

import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentMainRecentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainRecentFragment :
    BaseFragment<FragmentMainRecentBinding>(FragmentMainRecentBinding::inflate) {
    override val backPressCallback: () -> Boolean
        get() = {
            requireActivity().finish()
            true
        }
}