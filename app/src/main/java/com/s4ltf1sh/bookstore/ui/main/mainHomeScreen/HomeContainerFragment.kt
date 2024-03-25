package com.s4ltf1sh.bookstore.ui.main.mainHomeScreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.components.adapters.BaseViewPagerAdapter
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentHomeContainerBinding
import com.s4ltf1sh.bookstore.ui.main.mainHomeScreen.categoryScreen.CategoryFragment
import com.s4ltf1sh.bookstore.ui.main.mainHomeScreen.discoverScreen.DiscoverFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeContainerFragment :
    BaseFragment<FragmentHomeContainerBinding>(FragmentHomeContainerBinding::inflate) {
    private val mListFragments = mutableListOf<Triple<Fragment, String, Int>>()
    private lateinit var mPagerAdapter: BaseViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textDiscover = getString(R.string.discover)
        val textCategory = getString(R.string.category)

        mListFragments.addAll(
            listOf(
                Triple(DiscoverFragment(), textDiscover, R.drawable.ic_compass),
                Triple(CategoryFragment(), textCategory, R.drawable.ic_category)
            )
        )
    }

    override fun initView() {
        super.initView()

        setupViewPager()
        setupTabLayout()
    }

    private fun setupViewPager() {
        mPagerAdapter = BaseViewPagerAdapter(mListFragments, childFragmentManager, lifecycle)
        viewBinding.homeContainerFmViewPager.adapter = mPagerAdapter
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupTabLayout() {
        viewBinding.apply {
            TabLayoutMediator(homeContainerFmTabLayout, homeContainerFmViewPager) { tab, position ->
                tab.text = mPagerAdapter.getTitle(position)
                tab.icon = resources.getDrawable(mPagerAdapter.getIconRes(position), null)
            }.attach()
        }
    }
}