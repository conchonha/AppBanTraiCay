package com.example.appbantraicay.di;

import com.example.appbantraicay.data.services.ApiServices
import com.example.appbantraicay.data.repository.IActionRepository
import com.example.appbantraicay.data.repository.Repository
import com.example.appbantraicay.utils.SharePrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/18/2022
*/
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
//    @Provides
//    @Singleton
//    fun provideIActionRepository(
//        apiServices: ApiServices,
//        sharePrefs: SharePrefs
//    ): IActionRepository = Repository(apiServices, sharePrefs)
}
