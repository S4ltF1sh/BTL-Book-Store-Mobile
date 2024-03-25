package com.s4ltf1sh.bookstore.ui.detailScreen

import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.databinding.FragmentBookDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailFragment :
    BaseFragment<FragmentBookDetailBinding>(FragmentBookDetailBinding::inflate) {
    override fun initView() {
        super.initView()

        setupDemo()
    }

    private fun setupDemo() {
        val book = DataDemo.bookDemo
        viewBinding.apply {
            tvBookDetailTitle.text = book.title
            tvBookDetailAuthor.text = book.author
            tvBookCategory.text = book.category
            tvBookRating.text = book.rating.toString()
            tvBookPricing.text = getString(R.string.price_s, book.price.toString())
            tvDescription.text = book.description
        }
    }
}