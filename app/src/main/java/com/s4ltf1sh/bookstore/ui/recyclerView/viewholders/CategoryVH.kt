package com.s4ltf1sh.bookstore.ui.recyclerView.viewholders

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.s4ltf1sh.bookstore.common.extensions.loadImage
import com.s4ltf1sh.bookstore.data.model.Category
import com.s4ltf1sh.bookstore.databinding.ItemCategoryBinding

class CategoryVH(private val mBinding: ItemCategoryBinding) : ViewHolder(mBinding.root) {
    fun bind(item: Category, listener: CategoryListener) {
        mBinding.apply {
            ivCateCover.loadImage(item.cover)
            tvCateName.text = item.name

            root.setOnClickListener {
                listener.onCategoryClicked(item)
            }
        }
    }

    interface CategoryListener {
        fun onCategoryClicked(item: Category)
    }
}