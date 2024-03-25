package com.s4ltf1sh.bookstore.ui.main.mainRecentScreen.favoriteScreen

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.activities.MainActivity
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.constants.Const
import com.s4ltf1sh.bookstore.common.extensions.setMarginDecor
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.databinding.FragmentRecentFavoriteBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.adapters.BookDefaultAdapter
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.BookDefaultVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment :
    BaseFragment<FragmentRecentFavoriteBinding>(FragmentRecentFavoriteBinding::inflate) {
    private var booksAdapter: BookDefaultAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getBookListener()?.let { booksAdapter = BookDefaultAdapter(it) }
    }

    override fun initView() {
        super.initView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewBinding.apply {
            favoriteFmRvFavoriteBooks.layoutManager = getLayoutManager()
            favoriteFmRvFavoriteBooks.setMarginDecor(R.dimen.margin_medium)
            booksAdapter?.let { favoriteFmRvFavoriteBooks.adapter = it }
        }
    }

    override fun observeData() {
        super.observeData()
        booksAdapter?.submitList(DataDemo.listBookDemo)
    }

    private fun getLayoutManager(): GridLayoutManager {
        return object : GridLayoutManager(requireContext(), Const.GRID_SPAN_COUNT) {
        }
    }

    private fun getBookListener(): BookDefaultVH.BookListener? {
        return (activity as? MainActivity)?.getBookListener()
    }
}