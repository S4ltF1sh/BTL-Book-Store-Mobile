package com.s4ltf1sh.bookstore.ui.main.mainRecentScreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.components.adapters.BaseViewPagerAdapter
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.databinding.FragmentRecentContainerBinding
import com.s4ltf1sh.bookstore.ui.main.mainRecentScreen.favoriteScreen.FavoriteFragment
import com.s4ltf1sh.bookstore.ui.main.mainRecentScreen.recentScreen.RecentFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentContainerFragment :
    BaseFragment<FragmentRecentContainerBinding>(FragmentRecentContainerBinding::inflate) {
    private val mListFragments = mutableListOf<Triple<Fragment, String, Int>>()
    private lateinit var mPagerAdapter: BaseViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textRecent = getString(R.string.recent)
        val textFavorite = getString(R.string.favorite)

        mListFragments.addAll(
            listOf(
                Triple(RecentFragment(), textRecent, R.drawable.ic_recent),
                Triple(FavoriteFragment(), textFavorite, R.drawable.ic_heart_favorite)
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
        viewBinding.recentContainerFmViewPager.adapter = mPagerAdapter
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setupTabLayout() {
        viewBinding.apply {
            TabLayoutMediator(
                recentContainerFmTabLayout,
                recentContainerFmViewPager
            ) { tab, position ->
                tab.text = mPagerAdapter.getTitle(position)
                tab.icon = resources.getDrawable(mPagerAdapter.getIconRes(position), null)
            }.attach()
        }
    }
}