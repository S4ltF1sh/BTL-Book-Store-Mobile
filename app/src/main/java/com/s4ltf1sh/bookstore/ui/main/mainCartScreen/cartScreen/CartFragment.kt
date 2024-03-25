package com.s4ltf1sh.bookstore.ui.main.mainCartScreen.cartScreen

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.extensions.setVerticalMarginDecor
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.data.model.CartItem
import com.s4ltf1sh.bookstore.databinding.FragmentCartBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.adapters.CartItemAdapter
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.CartItemVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {
    private var cartAdapter: CartItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getCartItemListener().let { cartAdapter = CartItemAdapter(it) }
    }

    override fun initView() {
        super.initView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewBinding.apply {
            cartFmRvCartItems.layoutManager = getLayoutManager()
            cartFmRvCartItems.setVerticalMarginDecor(
                R.dimen.margin_zero, R.dimen.margin_default
            )
            cartAdapter?.let { cartFmRvCartItems.adapter = it }
        }
    }

    override fun observeData() {
        super.observeData()
        cartAdapter?.submitList(DataDemo.listItemCartDemo)
    }

    private fun getLayoutManager(): LinearLayoutManager {
        return object : LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
        }
    }

    private fun getCartItemListener(): CartItemVH.CartItemListener {
        return object : CartItemVH.CartItemListener {
            override fun onItemClicked(item: CartItem) {
//                TODO("Not yet implemented")
            }

            override fun onIncreaseQuantity(item: CartItem) {
//                TODO("Not yet implemented")
            }

            override fun onDecreaseQuantity(item: CartItem) {
//                TODO("Not yet implemented")
            }

            override fun onRemoveItem(item: CartItem) {
//                TODO("Not yet implemented")
            }
        }
    }
}