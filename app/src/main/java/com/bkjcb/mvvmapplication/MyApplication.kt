package com.bkjcb.mvvmapplication

import android.app.Application
import com.bkjcb.base.loadsir.LoadsirUtil

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        LoadsirUtil.initLoadsir()
    }
}