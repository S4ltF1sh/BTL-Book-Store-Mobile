package com.s4ltf1sh.bookstore.base.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.activities.BaseActivity
import com.s4ltf1sh.bookstore.base.network.BaseNetworkException
import com.s4ltf1sh.bookstore.base.viewmodel.BaseViewModel
import com.s4ltf1sh.bookstore.common.EventObserver
import com.s4ltf1sh.bookstore.common.extensions.FragmentInflate

abstract class BaseFragment<VB : ViewBinding>(private val inflate: FragmentInflate<VB>) :
    Fragment() {
    private var _viewBinding: VB? = null
    protected val viewBinding: VB
        get() = _viewBinding!!

    open val backPressCallback = {
        findNavController().popBackStack()
    }

    private fun initFragment(inflater: LayoutInflater, container: ViewGroup?) {
        //init child's view binding:
        _viewBinding = inflate.invoke(inflater, container, false)
    }

    private fun handleSystemBackPress() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    backPressCallback()
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initFragment(inflater, container)
        handleSystemBackPress()
        return _viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setupActions()
        observeData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    open fun initView() {}
    open fun setupActions() {}
    open fun observeData() {}

    fun <T> registerObserveDataBackFromForwardFragment(key: String, action: (T) -> Unit) {
        val navController = findNavController()
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)
            ?.observe(viewLifecycleOwner) {
                action(it)
            }
    }

    // Navigation:
    fun navigate(
        @IdRes action: Int,
        vararg data: Pair<String, Any?>
    ) {
        navigate(action, null, true, *data)
    }

    fun navigate(
        @IdRes action: Int,
        builder: NavOptions.Builder? = null,
        haveDefaultAnim: Boolean = true,
        vararg data: Pair<String, Any?>
    ) {
        val navController = findNavController()
        val bundle = bundleOf(*data)

        val optionBuilder = builder ?: NavOptions.Builder()

        if (haveDefaultAnim)
            optionBuilder.apply {
                setExitAnim(R.anim.slide_out_to_left)
                setEnterAnim(R.anim.slide_in_from_right)
                setPopExitAnim(R.anim.slide_out_to_right)
                setPopEnterAnim(R.anim.slide_in_from_left)
            }

        navController.navigate(action, bundle, optionBuilder.build())
    }

    fun popBackStack(
        vararg data: Pair<String, Any?>
    ): Boolean {
        return popBackStack(null, false, *data)
    }

    fun popBackStack(
        @IdRes destinationId: Int? = null,
        inclusive: Boolean = false,
        vararg data: Pair<String, Any?>
    ): Boolean {
        val navController = findNavController()

        navController.previousBackStackEntry?.savedStateHandle?.apply {
            data.forEach {
                set(it.first, it.second)
            }
        }

        return if (destinationId == null)
            navController.popBackStack()
        else popBackStackTo(destinationId, inclusive)
    }

    private fun popBackStackTo(@IdRes destinationId: Int, inclusive: Boolean = false): Boolean {
        return findNavController().popBackStack(destinationId, inclusive)
    }

    // Register observer:
    protected fun registerObserverExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.baseNetworkException.observe(viewLifecycleOwner, EventObserver {
            showErrorMessage(it)
        })
    }

    protected fun registerObserverNetworkExceptionEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.networkException.observe(viewLifecycleOwner, EventObserver {
            showNotify(getDefaultNotifyTitle(), it.message ?: "Network error")
        })
    }

    protected fun registerObserverMessageEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.errorMessageResourceId.observe(viewLifecycleOwner, EventObserver { message ->
            showErrorMessage(message)
        })
    }

    protected fun registerObserverLoadingMoreEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner
    ) {
        viewModel.isLoadingMore.observe(viewLifecycleOwner, EventObserver { isShow ->
            showLoadingMore(isShow)
        })
    }

    protected fun showLoadingMore(isShow: Boolean) {

    }

    // Show dialog:
    protected fun showLoading(isShow: Boolean) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showLoading(isShow)
        }
    }

    protected fun showErrorMessage(e: BaseNetworkException) {
        showErrorMessage(e.mainMessage)
    }

    protected fun showErrorMessage(messageId: Int) {
        val message = requireContext().getString(messageId)
        showErrorMessage(message)
    }

    protected fun showErrorMessage(message: String) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showErrorDialog(message)
        }
    }

    protected fun showNotify(title: String?, message: String) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showNotifyDialog(title ?: getDefaultNotifyTitle(), message)
        }
    }

    protected fun showNotify(titleId: Int = R.string.default_notify_title, messageId: Int) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showNotifyDialog(titleId, messageId)
        }
    }

    private fun getDefaultNotifyTitle(): String {
        return getString(R.string.default_notify_title)
    }
}