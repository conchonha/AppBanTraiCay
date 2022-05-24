package com.example.appbantraicay.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentOrderBinding
import com.sangtb.androidlibrary.base.BaseFragment

class OrderFragment : BaseFragment<FragmentOrderBinding, OrderViewModel>(){
    override val layoutId: Int
        get() = R.layout.fragment_order
    override val viewModel: OrderViewModel by viewModels()
}