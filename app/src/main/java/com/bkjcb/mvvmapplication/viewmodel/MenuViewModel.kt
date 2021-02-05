package com.bkjcb.mvvmapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkjcb.mvvmapplication.model.MenuItem
import com.bkjcb.mvvmapplication.repository.MenuRepository

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
class MenuViewModel(repository: MenuRepository, application: Application) : AndroidViewModel(
    application
) {
    private val menuItems: MutableLiveData<List<MenuItem>> =
        MutableLiveData(repository.getMenuItem())

    fun getMenuItemList(): MutableLiveData<List<MenuItem>> {
        return menuItems
    }
}