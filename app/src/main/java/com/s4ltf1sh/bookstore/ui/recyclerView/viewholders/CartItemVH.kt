package com.s4ltf1sh.bookstore.ui.recyclerView.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.common.extensions.loadImage
import com.s4ltf1sh.bookstore.data.model.CartItem
import com.s4ltf1sh.bookstore.databinding.ItemCartBinding

class CartItemVH(private val mBinding: ItemCartBinding) : ViewHolder(mBinding.root) {
    fun bind(item: CartItem, listener: CartItemListener) {
        val book = item.book
        mBinding.apply {
            ivBookCover.loadImage(book.cover)
            tvBookTitle.text = book.title
            tvBookAuthor.text = book.author
            tvBookPrice.text = root.context.getString(R.string.price_s, book.price.toString())
            tvQuantity.text = item.quantity.toString()

            root.setOnClickListener {
                listener.onItemClicked(item)
            }

            btnMinus.setOnClickListener {
                listener.onDecreaseQuantity(item)
            }

            btnPlus.setOnClickListener {
                listener.onIncreaseQuantity(item)
            }

            btnRemove.setOnClickListener {
                listener.onRemoveItem(item)
            }
        }
    }

    interface CartItemListener {
        fun onItemClicked(item: CartItem)
        fun onIncreaseQuantity(item: CartItem)
        fun onDecreaseQuantity(item: CartItem)
        fun onRemoveItem(item: CartItem)
    }
}