package com.example.appbantraicay.common;

import com.example.appbantraicay.data.model.Advertisement
import kotlinx.coroutines.*

/*
    Copyright © 2022 UITS CO.,LTD
    Created by SangTB on 5/24/2022
*/
abstract class BaseRepository1 {
    protected val toastManager = ToastManager1.getInstance()

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): T? {
        toastManager.loadingDialog.postValue(true)
        return withContext(Dispatchers.IO) {
            try {
                apiCall.invoke()
            } catch (e: Throwable) {
                toastManager.errorThrowable.postValue(e)
                toastManager.loadingDialog.postValue(false)
                null
            }
        }
    }

    suspend fun <T> safeApiCall(vararg apiCall: suspend()->T): List<Pair<Int, T>>? {
        toastManager.loadingDialog.postValue(true)

        return withContext(Dispatchers.IO) {
            val runningTasks = apiCall.mapIndexed { index, function ->
                async {
                    val apiResponse = function.invoke()
                    index to apiResponse
                }
            }
            try {
                runningTasks.awaitAll()
            } catch (e: Throwable) {
                toastManager.errorThrowable.postValue(e)
                toastManager.loadingDialog.postValue(false)
                coroutineContext.cancelChildren()
                null
            }
        }
    }
}
