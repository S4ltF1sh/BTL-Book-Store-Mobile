package com.s4ltf1sh.bookstore.base.dialogs

import android.content.Context
import com.s4ltf1sh.bookstore.common.extensions.ifNotNull
import com.s4ltf1sh.bookstore.common.extensions.visible
import com.s4ltf1sh.bookstore.databinding.DialogConfirmBinding

class ConfirmDialog(
    context: Context,
    private val callback: ConfirmCallback?,
    private val title: String,
    private val message: String?,
    private val positiveButtonTitle: String,
    private val negativeButtonTitle: String
) : BaseDialog<DialogConfirmBinding>(context, DialogConfirmBinding::inflate) {
    override fun initView() {
        viewBinding.apply {
            tvTitle.text = title

            message?.ifNotNull {
                tvContent.visible()
                tvContent.text = message
            }

            btnNegative.text = negativeButtonTitle
            btnPositive.text = positiveButtonTitle
        }
    }

    override fun setupActions() {
        viewBinding.apply {
            btnNegative.setOnClickListener {
                callback?.negativeAction()
                dismiss()
            }

            btnPositive.setOnClickListener {
                callback?.positiveAction()
                dismiss()
            }
        }
    }

    interface ConfirmCallback {
        fun negativeAction()
        fun positiveAction()
    }
}