package com.s4ltf1sh.bookstore.ui.detailScreen

import android.widget.Toast
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.extensions.visible
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.databinding.FragmentBookDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailFragment :
    BaseFragment<FragmentBookDetailBinding>(FragmentBookDetailBinding::inflate) {
    override fun initView() {
        super.initView()
        setupHeader()
        setupDemo()
    }

    private fun setupHeader() {
        viewBinding.header.apply {
            tvTitle.text = getString(R.string.detail)
            btnNavigation.setOnClickListener {
                popBackStack()
            }
            btnExtra.isEnabled = true
            btnExtra.setImageResource(R.drawable.ic_cart)
            btnExtra.visible()
            btnExtra.setOnClickListener {
                handleAddToCartClick()
            }
        }
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

    private fun handleAddToCartClick() {
        //TODO: handle add to cart
        Toast.makeText(requireContext(), "Add to cart", Toast.LENGTH_SHORT).show()
    }
}