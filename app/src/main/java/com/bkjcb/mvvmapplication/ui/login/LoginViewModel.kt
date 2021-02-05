package com.bkjcb.mvvmapplication.ui.login

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bkjcb.base.utils.SharedPreferencesUtil
import com.bkjcb.base.utils.Util
import com.bkjcb.mvvmapplication.BR
import com.bkjcb.mvvmapplication.util.Constants
import java.util.logging.Level

/**
 * Created by DengShuai on 2021/2/4.
 * Description :
 */
class LoginViewModel(val application: Application) : BaseObservable() {
    private val sp = SharedPreferencesUtil.getSP(application, Constants.USER_INFO)
    val username: String?
        get() = sp.getString(Constants.USER_INFO_NAME, "")
    val password: String?
        get() = sp.getString(Constants.USER_INFO_PASSWORD, "")
    val rememberPasswordFlag: Boolean
        get() = sp.getBoolean(Constants.USER_INFO_REMEMBER, false)
    val appVersion: String
        get() = "版本号：" + Util.getCurrentVersion(application)

    @get:Bindable
    var userLevel: Int = -1
        set(value) {
            field = value
            notifyPropertyChanged(BR.userLevel)
            notifyPropertyChanged(BR.userTipString)
        }

    @get:Bindable
    val userTipString: String
        get() {
            val str = when (userLevel) {
                0 -> "市级"
                1 -> "区级"
                2 -> "街镇"
                else -> "未知"
            }
            return "当前为${str}用户"
        }


}