package com.s4ltf1sh.bookstore.ui.recyclerView.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.s4ltf1sh.bookstore.base.components.adapters.BaseListAdapter
import com.s4ltf1sh.bookstore.data.model.Book
import com.s4ltf1sh.bookstore.databinding.ItemBookDefaultBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.diffUtilCallbacks.BookDiffCallback
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.BookDefaultVH

class BookDefaultAdapter(private val mBookListener: BookDefaultVH.BookListener) :
    BaseListAdapter<Book>(BookDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookDefaultVH(
            ItemBookDefaultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BookDefaultVH).bind(getItem(position), mBookListener)
    }
}