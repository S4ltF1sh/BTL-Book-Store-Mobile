package com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks

import androidx.recyclerview.widget.DiffUtil
import com.s4ltf1sh.bookstore.data.model.CartItem

class CartItemDiffCallback : DiffUtil.ItemCallback<CartItem>() {
    override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return oldItem == newItem
    }
}