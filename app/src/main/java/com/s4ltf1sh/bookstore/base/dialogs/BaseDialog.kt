package com.s4ltf1sh.bookstore.base.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import androidx.viewbinding.ViewBinding
import com.s4ltf1sh.bookstore.common.extensions.DialogInflate

abstract class BaseDialog<VB : ViewBinding>(
    context: Context,
    private val inflate: DialogInflate<VB>,
    private val isCancelable: Boolean = true,
    private val isCanceledOnTouchOutside: Boolean = true
) : Dialog(context) {
    private var _viewBinding: VB? = null
    protected val viewBinding: VB
        get() = _viewBinding!!

    private fun initDialog() {
        //init view binding:
        _viewBinding = inflate.invoke(layoutInflater, null, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        initDialog()
        setContentView(viewBinding.root)

        initView()
        setupActions()

        setCancelable(isCancelable)
        setCanceledOnTouchOutside(isCanceledOnTouchOutside)

        setOnShowListener { onShow() }
        setOnCancelListener { onCancel() }
        setOnDismissListener { onDismiss() }
    }

    open fun initView() {}
    open fun setupActions() {}

    open fun onShow() {}
    open fun onDismiss() {}
    open fun onCancel() {}
}