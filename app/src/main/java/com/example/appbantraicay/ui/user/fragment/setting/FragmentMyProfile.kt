package com.example.appbantraicay.ui.user.fragment.setting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentMyProfileBinding
import com.example.appbantraicay.ui.user.fragment.setting.viewmodel.MyProfileViewModel
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 08/06/2022.
*/

@AndroidEntryPoint
class FragmentMyProfile : BaseFragment<FragmentMyProfileBinding, MyProfileViewModel>(){
    override val layoutId: Int
        get() = R.layout.fragment_my_profile

    override val viewModel: MyProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}