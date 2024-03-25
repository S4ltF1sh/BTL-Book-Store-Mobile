package com.s4ltf1sh.bookstore.data.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val price: Float,
    val rating: Float,
    val cover: String,
    val description: String,
    val category: String,
    val quantity: Int
) {
}