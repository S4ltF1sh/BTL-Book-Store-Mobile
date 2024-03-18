package com.s4ltf1sh.bookstore.base.dialogs

import android.content.Context
import com.s4ltf1sh.bookstore.common.extensions.ifNotNull
import com.s4ltf1sh.bookstore.databinding.DialogErrorBinding

class ErrorDialog(
    context: Context,
    private val errorContent: String,
    private val textButton: String? = null
) : BaseDialog<DialogErrorBinding>(context, DialogErrorBinding::inflate) {
    override fun initView() {
        viewBinding.apply {
            tvContentError.text = errorContent
            textButton?.ifNotNull { btnOK.text = it }
        }
    }
    
    override fun setupActions() {
        viewBinding.apply {
            btnOK.setOnClickListener { dismiss() }
        }
    }
}