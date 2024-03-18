package com.s4ltf1sh.bookstore.base.network

import com.s4ltf1sh.bookstore.common.constants.Strings

class BaseNetworkException (
    val responseMessage: String? = null,
    val responseCode: Int = -1
) : Exception() {

    var mainMessage = Strings.EMPTY

    fun parseFromString(errorBody: String) {

    }
}