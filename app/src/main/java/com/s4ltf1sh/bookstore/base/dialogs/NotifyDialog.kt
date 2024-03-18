package com.s4ltf1sh.bookstore.base.dialogs

import android.content.Context
import com.s4ltf1sh.bookstore.common.extensions.ifNotNull
import com.s4ltf1sh.bookstore.common.extensions.setTextHtml
import com.s4ltf1sh.bookstore.databinding.DialogNotifyBinding

class NotifyDialog(
    context: Context,
    private val title: String,
    private val message: String,
    private val textButton: String? = null
) : BaseDialog<DialogNotifyBinding>(context, DialogNotifyBinding::inflate) {

    override fun initView() {
        viewBinding.apply {
            tvTitle.text = title
            tvContent.setTextHtml(message)
            textButton.ifNotNull { btnOK.text = it }
        }
    }

    override fun setupActions() {
        viewBinding.apply {
            btnOK.setOnClickListener { dismiss() }
        }
    }

}