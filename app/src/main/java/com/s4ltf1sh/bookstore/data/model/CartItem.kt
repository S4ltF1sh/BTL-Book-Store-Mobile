package com.s4ltf1sh.bookstore.data.model

data class CartItem(
    val id: Int,
    val book: Book,
    var quantity: Int
)
