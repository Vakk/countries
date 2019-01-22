package com.valery.myapplication.ui.base.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.valery.myapplication.ui.base.mvvm.ActionLiveData

/**
 * You can describe some custom logic here and apply for the whole app (refresh session, process messages and other cases).
 */
abstract class BaseViewModel : ViewModel() {

    val onMessageLiveData = ActionLiveData<String>()
    val onLoadingLiveData = MutableLiveData<Boolean>()

    fun showMessage(message: String) {
        onMessageLiveData.value = message
    }

    fun showLoader() {
        onLoadingLiveData.value = true
    }

    fun hideLoader() {
        onLoadingLiveData.value = false
    }
}