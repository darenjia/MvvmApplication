package com.bkjcb.base.utils

import android.app.Application
import android.content.SharedPreferences

/**
 * Created by DengShuai on 2021/2/4.
 * Description :
 */
object SharedPreferencesUtil {
    fun getSP(application: Application, name: String):SharedPreferences{
      return  application.getSharedPreferences(name, android.content.Context.MODE_PRIVATE)
    }

}