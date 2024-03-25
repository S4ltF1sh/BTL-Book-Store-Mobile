package com.s4ltf1sh.bookstore.ui.main.mainHomeScreen.categoryScreen

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.s4ltf1sh.bookstore.R
import com.s4ltf1sh.bookstore.base.fragments.BaseFragment
import com.s4ltf1sh.bookstore.common.constants.Const
import com.s4ltf1sh.bookstore.common.extensions.setMarginDecor
import com.s4ltf1sh.bookstore.common.extensions.setVerticalMarginDecor
import com.s4ltf1sh.bookstore.data.DataDemo
import com.s4ltf1sh.bookstore.data.model.Category
import com.s4ltf1sh.bookstore.databinding.FragmentHomeCategoryBinding
import com.s4ltf1sh.bookstore.ui.recyclerView.adapters.CategoryAdapter
import com.s4ltf1sh.bookstore.ui.recyclerView.viewholders.CategoryVH
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment :
    BaseFragment<FragmentHomeCategoryBinding>(FragmentHomeCategoryBinding::inflate) {
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getCategoryListener().let { categoryAdapter = CategoryAdapter(it) }
    }

    override fun initView() {
        super.initView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewBinding.apply {
            categoryFmRvCategories.layoutManager = getLayoutManager()
            categoryFmRvCategories.setMarginDecor(R.dimen.margin_medium)
            categoryAdapter?.let { categoryFmRvCategories.adapter = it }
        }
    }

    override fun observeData() {
        super.observeData()
        categoryAdapter?.submitList(DataDemo.listCategoryDemo)
    }

    private fun getLayoutManager(): GridLayoutManager {
        return object : GridLayoutManager(requireContext(), Const.GRID_SPAN_COUNT) {
        }
    }

    private fun getCategoryListener(): CategoryVH.CategoryListener {
        return object : CategoryVH.CategoryListener {
            override fun onCategoryClicked(item: Category) {

            }
        }
    }
}