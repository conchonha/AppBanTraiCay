package com.example.appbantraicay.ui.admin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentAdminBinding
import com.sangtb.androidlibrary.base.BaseFragment

class Admin : BaseFragment<FragmentAdminBinding, AdminViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_admin
    override val viewModel: AdminViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel
        }
    }
}