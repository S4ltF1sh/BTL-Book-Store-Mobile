package com.s4ltf1sh.bookstore.ui.recyclerView.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.s4ltf1sh.bookstore.base.components.adapters.BaseListAdapter
import com.s4ltf1sh.bookstore.data.model.Category
import com.s4ltf1sh.bookstore.databinding.ItemCategoryBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks.CategoryDiffCallback
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.CategoryVH

class CategoryAdapter(private val mCategoryListener: CategoryVH.CategoryListener) :
    BaseListAdapter<Category>(CategoryDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryVH(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CategoryVH).bind(getItem(position), mCategoryListener)
    }
}