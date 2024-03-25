package com.s4ltf1sh.bookstore.ui.searchScreen

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.activities.MainActivity
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.constants.Const
import com.s4ltf1sh.bookstore.common.extensions.setMarginDecor
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.databinding.FragmentSearchBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.adapters.BookDefaultAdapter
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.BookDefaultVH

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    private var booksAdapter: BookDefaultAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getBookListener()?.let { booksAdapter = BookDefaultAdapter(it) }
    }

    override fun initView() {
        super.initView()
        setupRecyclerView()
        setupDemo()
    }

    private fun setupDemo() {
        val search = "the"
        viewBinding.apply {
            searchFmEtSearch.setText(search)
            searchFmTvResultFor.text = getString(R.string.result_for_s, search)
        }
    }

    private fun setupRecyclerView() {
        viewBinding.apply {
            searchFmRvResultBooks.layoutManager = getLayoutManager()
            searchFmRvResultBooks.setMarginDecor(R.dimen.margin_medium)
            booksAdapter?.let { searchFmRvResultBooks.adapter = it }
        }
    }

    override fun observeData() {
        super.observeData()
        booksAdapter?.submitList(DataDemo.listBookSearchDemo)
    }

    private fun getLayoutManager(): GridLayoutManager {
        return object : GridLayoutManager(requireContext(), Const.GRID_SPAN_COUNT) {
        }
    }

    private fun getBookListener(): BookDefaultVH.BookListener? {
        return (activity as? MainActivity)?.getBookListener()
    }
}