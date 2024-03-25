package com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks

import androidx.recyclerview.widget.DiffUtil
import com.s4ltf1sh.bookstore.data.model.Category

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}