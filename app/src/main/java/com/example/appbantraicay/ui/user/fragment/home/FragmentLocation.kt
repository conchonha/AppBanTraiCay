package com.example.appbantraicay.ui.user.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.appbantraicay.R
import com.example.appbantraicay.databinding.FragmentLocationBinding
import com.example.appbantraicay.ui.user.fragment.home.viewmodel.HomeViewModel
import com.example.appbantraicay.ui.user.fragment.setting.viewmodel.MyProfileViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.sangtb.androidlibrary.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/*
* Copyright © 2022 UITS CO.,LTD
* Created by SangTB on 10/06/2022.
*/

@AndroidEntryPoint
class FragmentLocation : BaseFragment<FragmentLocationBinding,HomeViewModel>(),
    OnMapReadyCallback {
    private var mMap: GoogleMap? = null

    override val layoutId: Int
        get() = R.layout.fragment_location
    override val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        (childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment)?.let {
            it.getMapAsync(this)
        }
    }

    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0
        Log.d(TAG, "onMapReady: $mMap")
        mMap?.apply {
            val latLng = LatLng(15.972540, 108.249584)
            addMarker(
                MarkerOptions().position(latLng).title(getString(R.string.school))
                    .snippet(getString(R.string.description_school)).icon(BitmapDescriptorFactory.defaultMarker())
            )

            mapType = GoogleMap.MAP_TYPE_SATELLITE
            val cameraPosition = CameraPosition.Builder().target(latLng).zoom(15f).build()
            animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }
}