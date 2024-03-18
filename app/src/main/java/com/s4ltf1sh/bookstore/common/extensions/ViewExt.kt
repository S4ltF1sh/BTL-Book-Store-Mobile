package com.s4ltf1sh.bookstore.common.extensions

import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.isVisible() = visibility == View.VISIBLE
fun View.isGone() = visibility == View.GONE
fun View.isInvisible() = visibility == View.INVISIBLE

fun View.showIf(condition: Boolean) {
    if (condition) {
        visible()
    } else {
        gone()
    }
}

fun View.hideIf(condition: Boolean) {
    if (condition) {
        gone()
    } else {
        visible()
    }
}

fun View.toggleVisibility() {
    if (isVisible()) {
        gone()
    } else {
        visible()
    }
}

fun View.toggleInvisibility() {
    if (isInvisible()) {
        visible()
    } else {
        invisible()
    }
}

fun View.toggleGone() {
    if (isGone()) {
        visible()
    } else {
        gone()
    }
}

fun TextView.setTextHtml(text: String) {
    this.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
}