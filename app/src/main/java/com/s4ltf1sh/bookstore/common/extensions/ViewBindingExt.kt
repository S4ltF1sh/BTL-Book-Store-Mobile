package com.s4ltf1sh.bookstore.common.extensions

import android.view.LayoutInflater
import android.view.ViewGroup

typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

typealias ActivityInflate<T> = (LayoutInflater) -> T

typealias DialogInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T