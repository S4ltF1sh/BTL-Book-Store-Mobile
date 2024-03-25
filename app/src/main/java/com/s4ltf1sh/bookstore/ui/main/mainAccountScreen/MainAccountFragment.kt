package com.s4ltf1sh.bookstore.ui.main.mainAccountScreen

import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentMainAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainAccountFragment : BaseFragment<FragmentMainAccountBinding>(FragmentMainAccountBinding::inflate) {
    override val backPressCallback: () -> Boolean
        get() = {
            requireActivity().finish()
            true
        }
}