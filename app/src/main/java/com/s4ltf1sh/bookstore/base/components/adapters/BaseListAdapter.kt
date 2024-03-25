package com.s4ltf1sh.bookstore.base.components.adapters

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

abstract class BaseListAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, RecyclerView.ViewHolder>(
        AsyncDifferConfig.Builder(diffCallback)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    override fun submitList(list: List<T>?) {
        if (list.isNullOrEmpty()) {
            super.submitList(null)

        } else
            super.submitList(list.toMutableList())
    }

    fun removeAt(position: Int) {
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }
}