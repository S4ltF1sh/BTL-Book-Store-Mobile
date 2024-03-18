package com.s4ltf1sh.bookstore.common

import android.util.Log
import com.s4ltf1sh.bookstore.BuildConfig

object Logger {

    fun log(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

}