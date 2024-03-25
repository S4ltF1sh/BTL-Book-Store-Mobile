package com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks

import androidx.recyclerview.widget.DiffUtil
import com.s4ltf1sh.bookstore.data.model.Book

class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}