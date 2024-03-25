package com.s4ltf1sh.bookstore.base.components.itemDecors

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class VerticalMarginItemDecoration(context: Context, @DimenRes marginTopDp: Int, @DimenRes marginBotDp: Int) :
    RecyclerView.ItemDecoration() {

    private val marginTopPx: Int =
        context.resources.getDimension(marginTopDp).toInt()

    private val marginBotPx: Int =
        context.resources.getDimension(marginBotDp).toInt()

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.top = marginTopPx
        outRect.bottom = marginBotPx
    }

}