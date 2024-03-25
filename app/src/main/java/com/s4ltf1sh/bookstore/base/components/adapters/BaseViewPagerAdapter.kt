package com.s4ltf1sh.bookstore.base.components.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseViewPagerAdapter(
    private val listFragment: List<Triple<Fragment, String, Int>>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment = listFragment[position].first

    fun getTitle(position: Int): String = listFragment[position].second

    fun getIconRes(position: Int): Int = listFragment[position].third
}