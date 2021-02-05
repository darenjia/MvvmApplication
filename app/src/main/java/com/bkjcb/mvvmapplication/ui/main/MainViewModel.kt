package com.bkjcb.mvvmapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var data: MutableLiveData<String>? = null
    fun getDataString(): LiveData<String>? = this.data
    fun setDataString() {
        this.data = MutableLiveData<String>()
        this.data?.postValue("a")
    }
}