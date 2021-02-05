package com.bkjcb.base.utils

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import java.util.*

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
object Util {
    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun getUUID(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }

    fun getCurrentVersion(application: Application): String? {
        val packageManager: PackageManager = application.packageManager
        // getPackageName()是你当前类的包名
        var packInfo: PackageInfo? = null
        try {
            packInfo = packageManager.getPackageInfo(application.packageName, 0)
            return packInfo!!.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return "未知"
    }
}