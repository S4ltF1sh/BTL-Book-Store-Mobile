package com.s4ltf1sh.bookstore.ui.main.mainHomeScreen.discoverScreen

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.activities.MainActivity
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.extensions.setHorizontalMarginDecor
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.databinding.FragmentHomeDiscoverBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.adapters.BookDefaultAdapter
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.BookDefaultVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment :
    BaseFragment<FragmentHomeDiscoverBinding>(FragmentHomeDiscoverBinding::inflate) {
    private var mTopBookAdapter: BookDefaultAdapter? = null
    private var mRecommendedBookAdapter: BookDefaultAdapter? = null
    private var mNewBookAdapter: BookDefaultAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getBookListener()?.let {
            mTopBookAdapter = BookDefaultAdapter(it)
            mRecommendedBookAdapter = BookDefaultAdapter(it)
            mNewBookAdapter = BookDefaultAdapter(it)
        }
    }

    override fun initView() {
        super.initView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewBinding.apply {
            recoverFmRvTopBooks.layoutManager = getLayoutManager()
            recoverFmRvRecommendedBooks.layoutManager = getLayoutManager()
            recoverFmRvLatestBooks.layoutManager = getLayoutManager()

            recoverFmRvLatestBooks.setHorizontalMarginDecor(
                R.dimen.margin_zero,
                R.dimen.margin_default
            )
            recoverFmRvRecommendedBooks.setHorizontalMarginDecor(
                R.dimen.margin_zero,
                R.dimen.margin_default
            )
            recoverFmRvTopBooks.setHorizontalMarginDecor(
                R.dimen.margin_zero,
                R.dimen.margin_default
            )

            mTopBookAdapter?.let { recoverFmRvTopBooks.adapter = it }
            mRecommendedBookAdapter?.let { recoverFmRvRecommendedBooks.adapter = it }
            mNewBookAdapter?.let { recoverFmRvLatestBooks.adapter = it }
        }
    }

    override fun observeData() {
        super.observeData()
        mTopBookAdapter?.submitList(DataDemo.listBookDemo)
        mRecommendedBookAdapter?.submitList(DataDemo.listBookDemo)
        mNewBookAdapter?.submitList(DataDemo.listBookDemo)
    }

    private fun getLayoutManager(): LinearLayoutManager {
        return object : LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                lp?.width = width / 2
                return true
            }
        }
    }

    private fun getBookListener(): BookDefaultVH.BookListener? {
        return (activity as? MainActivity)?.getBookListener()
    }
}