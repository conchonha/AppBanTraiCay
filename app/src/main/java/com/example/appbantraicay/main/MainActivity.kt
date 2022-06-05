package com.example.appbantraicay.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.appbantraicay.R
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.data.repository.auth.AuthRepository
import com.example.appbantraicay.ui.dialog.LoadingDialog
import com.sangtb.androidlibrary.utils.ToastManager
import com.sangtb.androidlibrary.utils.setHideStatusBarAndControlBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _navHostController: NavController
    private lateinit var _navHostFragment: NavHostFragment
    private val dialog by lazy { LoadingDialog() }
    private val toastManager by lazy { ToastManager.getInstance() }

    @Inject
    @Singleton
    lateinit var repository: Repository

    @Inject
    @Singleton
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(repository)
        lifecycle.addObserver(authRepository)

        //set hide control bar and status bar
        setHideStatusBarAndControlBar()

        toastManager.loadingDialog.observe(this) {
            if (dialog.isAdded) dialog.dismiss()
            if (it){
                if (dialog.isAdded) dialog.dismiss()
                dialog.show(supportFragmentManager,TAG)
            }
        }

        toastManager.errorThrowable.observe(this){
            Toast.makeText(this,it.message.toString(),Toast.LENGTH_LONG).show()
        }

        _navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        _navHostController = _navHostFragment.navController
    }

    fun refreshCurrentFragment() {
        val id = _navHostController.currentDestination?.id
        _navHostController.popBackStack(id!!, true)
        _navHostController.navigate(id)
    }

    companion object {
        private val TAG = this.javaClass.name
    }
}