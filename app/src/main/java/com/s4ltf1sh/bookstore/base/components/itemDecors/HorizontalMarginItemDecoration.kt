package com.s4ltf1sh.bookstore.base.components.itemDecors

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginItemDecoration(context: Context, @DimenRes horizontalMarginRightDp: Int, @DimenRes horizontalMarginLeftDp: Int) :
    RecyclerView.ItemDecoration() {

    private val horizontalMarginRightPx: Int =
        context.resources.getDimension(horizontalMarginRightDp).toInt()

    private val horizontalMarginLeftPx: Int =
        context.resources.getDimension(horizontalMarginLeftDp).toInt()

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.right = horizontalMarginRightPx
        outRect.left = horizontalMarginLeftPx
    }

}