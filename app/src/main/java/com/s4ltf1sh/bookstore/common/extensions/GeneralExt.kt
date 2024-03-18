package com.s4ltf1sh.bookstore.common.extensions

fun <T> T?.isNull() = this == null

fun <T> T?.isNotNull() = this != null

inline fun <T> T?.ifNull(block: () -> Unit) {
    if (this == null) block()
}

inline fun <T> T?.ifNotNull(block: (T) -> Unit) {
    if (this != null) block(this)
}