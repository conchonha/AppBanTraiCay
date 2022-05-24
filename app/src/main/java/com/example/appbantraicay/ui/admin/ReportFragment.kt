package com.example.appbantraicay.ui.admin

import androidx.fragment.app.viewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentReportBinding
import com.sangtb.androidlibrary.base.BaseFragment

class ReportFragment : BaseFragment<FragmentReportBinding, ReportViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_report

    override val viewModel: ReportViewModel by viewModels()
}