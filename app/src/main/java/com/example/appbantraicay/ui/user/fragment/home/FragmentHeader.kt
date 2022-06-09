package com.example.appbantraicay.ui.user.fragment.home;

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentHeaderBinding
import com.example.appbantraicay.ui.user.adapter.AdapterSearch
import com.example.appbantraicay.ui.user.fragment.home.viewmodel.HeaderViewModel
import com.example.appbantraicay.utils.Const.TYPE_DETAIL
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/19/2022
*/
@AndroidEntryPoint
class FragmentHeader : BaseFragment<FragmentHeaderBinding, HeaderViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_header
    override val viewModel: HeaderViewModel by viewModels()

    @Inject
    lateinit var adapterSearch: AdapterSearch

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel1 = viewModel

            recyclerSearch.adapter = adapterSearch
            edtSearch.doAfterTextChanged(viewModel::doAfterSearchChange)
        }

        listener()
    }

    private fun listener() {
        viewModel.listSearchProduct.observe(viewLifecycleOwner){
            adapterSearch.updateItems(it.toMutableList())
        }

        adapterSearch.listener = {_, item, _ ->
            (parentFragment as? FragmentHome)?.viewModel?.bannerHomeClick(item.id) ?: (parentFragment as FragmentDetail).let {
                it.viewModel.bannerHomeClick(item.id,TYPE_DETAIL)
            }
            binding.apply {
                recyclerSearch.visibility = View.GONE
                edtSearch.setText(EMPTY)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadUserInfo()
    }

    companion object{
        private const val EMPTY = ""
    }
}
