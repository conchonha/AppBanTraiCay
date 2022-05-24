package com.example.appbantraicay.ui.admin

import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentProductBinding
import com.sangtb.androidlibrary.base.BaseFragment

class ProductFragment : BaseFragment<FragmentProductBinding, ProductViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_product
    override val viewModel: ProductViewModel by viewModels()
}