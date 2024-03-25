package com.s4ltf1sh.bookstore.ui.recyclerView.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.s4ltf1sh.bookstore.base.components.adapters.BaseListAdapter
import com.s4ltf1sh.bookstore.data.model.CartItem
import com.s4ltf1sh.bookstore.databinding.ItemCartBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks.CartItemDiffCallback
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.CartItemVH

class CartItemAdapter(private val mCartItemListener: CartItemVH.CartItemListener) :
    BaseListAdapter<CartItem>(CartItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CartItemVH(
            ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CartItemVH).bind(getItem(position), mCartItemListener)
    }
}