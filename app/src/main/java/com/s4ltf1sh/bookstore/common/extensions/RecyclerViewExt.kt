package com.s4ltf1sh.bookstore.common.extensions

import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.s4ltf1sh.bookstore.base.components.itemDecors.HorizontalMarginItemDecoration
import com.s4ltf1sh.bookstore.base.components.itemDecors.MarginItemDecoration
import com.s4ltf1sh.bookstore.base.components.itemDecors.VerticalMarginItemDecoration

fun RecyclerView.setHorizontalMarginDecor(@DimenRes marginLeft: Int, @DimenRes marginRight: Int) {
    addItemDecoration(HorizontalMarginItemDecoration(context, marginRight, marginLeft))
}

fun RecyclerView.setHorizontalMarginDecor(@DimenRes margin: Int) {
    addItemDecoration(HorizontalMarginItemDecoration(context, margin, margin))
}

fun RecyclerView.setVerticalMarginDecor(@DimenRes marginTop: Int, @DimenRes marginBottom: Int) {
    addItemDecoration(VerticalMarginItemDecoration(context, marginTop, marginBottom))
}

fun RecyclerView.setVerticalMarginDecor(@DimenRes margin: Int) {
    addItemDecoration(VerticalMarginItemDecoration(context, margin, margin))
}

fun RecyclerView.setMarginDecor(
    @DimenRes marginLeft: Int,
    @DimenRes marginRight: Int,
    @DimenRes marginTop: Int,
    @DimenRes marginBottom: Int
) {
    addItemDecoration(
        MarginItemDecoration(
            context,
            marginRight,
            marginLeft,
            marginTop,
            marginBottom
        )
    )
}

fun RecyclerView.setMarginDecor(@DimenRes margin: Int) {
    addItemDecoration(MarginItemDecoration(context, margin))
}