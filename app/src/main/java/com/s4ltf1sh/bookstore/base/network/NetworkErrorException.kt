package com.s4ltf1sh.bookstore.base.network

public open class NetworkErrorException (val responseMessage: String? = null): Exception() {
}