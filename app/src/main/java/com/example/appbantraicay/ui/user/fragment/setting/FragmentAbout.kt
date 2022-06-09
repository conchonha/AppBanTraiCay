package com.example.appbantraicay.ui.user.fragment.setting

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentAboutBinding
import com.example.appbantraicay.ui.user.fragment.setting.viewmodel.MyProfileViewModel
import com.example.appbantraicay.utils.Const
import com.sangtb.androidlibrary.base.BaseFragment
import com.sangtb.androidlibrary.utils.ToastManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAbout : BaseFragment<FragmentAboutBinding,MyProfileViewModel>() {
    private val toastManager by lazy { ToastManager.getInstance() }
    override val layoutId: Int
        get() = R.layout.fragment_about
    override val viewModel: MyProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.apply {
            loadUrl(Const.WEB_VIEW_URL)
            webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    toastManager.loadingDialog.postValue(true)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    toastManager.loadingDialog.postValue(false)
                }
            }
        }
    }
}