package com.s4ltf1sh.bookstore.base.components.itemDecors

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    context: Context,
    @DimenRes marginRightDp: Int,
    @DimenRes marginLeftDp: Int,
    @DimenRes marginTopDp: Int,
    @DimenRes marginBottomDp: Int
) :
    RecyclerView.ItemDecoration() {

    constructor(context: Context, @DimenRes marginDp: Int) : this(
        context,
        marginDp,
        marginDp,
        marginDp,
        marginDp
    )

    constructor(
        context: Context,
        @DimenRes horizontalMarginDp: Int,
        @DimenRes verticalMarginDp: Int
    ) : this(
        context,
        horizontalMarginDp,
        horizontalMarginDp,
        verticalMarginDp,
        verticalMarginDp
    )

    private
    val marginRightPx: Int =
        context.resources.getDimension(marginRightDp).toInt()

    private
    val marginLeftPx: Int =
        context.resources.getDimension(marginLeftDp).toInt()

    private
    val marginTopPx: Int =
        context.resources.getDimension(marginTopDp).toInt()

    private
    val marginBottomPx: Int =
        context.resources.getDimension(
            marginBottomDp
        ).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = marginRightPx
        outRect.left = marginLeftPx
        outRect.top = marginTopPx
        outRect.bottom = marginBottomPx
    }

}