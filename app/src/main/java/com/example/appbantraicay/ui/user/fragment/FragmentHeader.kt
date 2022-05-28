package com.example.appbantraicay.ui.user.fragment;

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentHeaderBinding
import com.example.appbantraicay.ui.user.viewmodel.HeaderViewModel
import com.example.appbantraicay.ui.user.viewmodel.HomeViewModel
import com.example.appbantraicay.utils.navigateDeepLink
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/19/2022
*/
@AndroidEntryPoint
class FragmentHeader : BaseFragment<FragmentHeaderBinding, HeaderViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_header
    override val viewModel: HeaderViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            action = viewModel

            txtLogin.setOnClickListener {
                navigateDeepLink(R.string.deeplink_action_login)
                viewModel.signOut()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadUserInfo()
    }
}
