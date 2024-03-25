package com.s4ltf1sh.bookstore.ui.recyclerView.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.common.extensions.loadImage
import com.s4ltf1sh.bookstore.data.model.Book
import com.s4ltf1sh.bookstore.databinding.ItemBookDefaultBinding

class BookDefaultVH(private val mBinding: ItemBookDefaultBinding) : ViewHolder(mBinding.root) {
    fun bind(item: Book, listener: BookListener) {
        mBinding.apply {
            ivBookCover.loadImage(item.cover)
            tvBookTitle.text = item.title
            tvBookAuthor.text = item.author
            tvBookPrice.text = root.context.getString(R.string.price_s, item.price.toString())

            root.setOnClickListener {
                listener.onBookClicked(item)
            }

            root.setOnLongClickListener {
                listener.onBookLongClicked(item)
            }
        }
    }

    interface BookListener {
        fun onBookClicked(item: Book)
        fun onBookLongClicked(item: Book): Boolean
    }
}