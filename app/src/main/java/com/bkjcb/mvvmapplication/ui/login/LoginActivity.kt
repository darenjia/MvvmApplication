package com.bkjcb.mvvmapplication.ui.login

import android.os.Bundle
import android.view.Window
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bkjcb.base.model.SimpleHttpResult
import com.bkjcb.base.model.SimpleObservable
import com.bkjcb.base.network.HttpRequestStatus
import com.bkjcb.base.network.NetworkApi
import com.bkjcb.base.utils.MD5Util
import com.bkjcb.base.utils.SharedPreferencesUtil
import com.bkjcb.base.utils.Util
import com.bkjcb.mvvmapplication.R
import com.bkjcb.mvvmapplication.databinding.ActivityLoginBinding
import com.bkjcb.mvvmapplication.model.User
import com.bkjcb.mvvmapplication.retrofit.LoginService
import com.bkjcb.mvvmapplication.util.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by DengShuai on 2021/2/4.
 * Description :
 */
class LoginActivity : AppCompatActivity() {
    private var errorTime: Long = 0
    private var errorCount = 0

    private var userNameString: String? = null
    private var userPasswordString: String? = null
    private lateinit var binding: ActivityLoginBinding

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding =
            DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        loginViewModel = LoginViewModel(application)
        binding.info = loginViewModel
        initView()
    }

    private fun initView() {
        resetRadioButtonImage(R.drawable.municipal_bg, binding.loginType1)
        resetRadioButtonImage(R.drawable.district_bg, binding.loginType2)
        resetRadioButtonImage(R.drawable.street_bg, binding.loginType3)

        binding.signInButton.setOnClickListener {
            userNameString = binding.username.text.toString()
            userPasswordString = binding.password.text.toString()
            if (userNameString!!.trim().isEmpty()) {
                binding.username.error = "用户名不能为空"
                binding.username.requestFocus()
                return@setOnClickListener
            }
            if (userPasswordString!!.trim().isEmpty()) {
                binding.password.error = "请输入密码!"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            saveUserInfo()
        }
        Thread(Runnable {
            Thread.sleep(5000)
            loginViewModel.userLevel = 1
        }).start()
    }

    private fun login(name: String, password: String) {
        if (errorCount >= 5 || errorTime > 0 && errorTime + 5 * 60 * 1000 > System.currentTimeMillis()) {
            Toast.makeText(this@LoginActivity, "多次登录失败！请在五分钟后重试", Toast.LENGTH_SHORT).show()
            return
        }
        NetworkApi.getService(LoginService::class.java)
            .getLoginUser(name, MD5Util.encode(password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(SimpleObservable<SimpleHttpResult<User>>(object :
                HttpRequestStatus<SimpleHttpResult<User>> {
                override fun requestSuccess(t: SimpleHttpResult<User>?) {
                    if (t != null) {
                        if (t.pushState == 200) {
//                            loginSuccess()
                        } else {
                            errorCount++
                            if (errorCount >= 5) {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "用户名或密码错误！(请在五分钟后重试)",
                                    Toast.LENGTH_SHORT
                                ).show()
                                saveErrorTime()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "用户名或密码错误！(剩余" + (5 - errorCount) + "次)",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }

                override fun requestFailure(msg: String?) {
                    Toast.makeText(this@LoginActivity, "登录失败，请检查网络！", Toast.LENGTH_SHORT).show()
                }

                override fun requestStart(d: Disposable) {
                    showLoading()
                }

                override fun requestComplete() {
                    TODO("Not yet implemented")
                }

            }))
    }

    private fun saveErrorTime() {
        SharedPreferencesUtil.getSP(application, Constants.USER_INFO)
            .edit()
            .putLong("limitTime", System.currentTimeMillis())
            .apply()
    }

    private fun showLoading() {
        TODO("Not yet implemented")
    }

    private fun saveUserInfo() {
        if (binding.boxPassword.isChecked) {
            SharedPreferencesUtil.getSP(application, Constants.USER_INFO)
                .edit()
                .putBoolean(Constants.USER_INFO_REMEMBER, true)
                .putString(Constants.USER_INFO_NAME, userNameString)
                .putString(Constants.USER_INFO_PASSWORD, userPasswordString)
                .putLong(Constants.USER_INFO_LIMIT_TIME, 0)
                .apply()
        } else {
            SharedPreferencesUtil.getSP(application, Constants.USER_INFO)
                .edit()
                .putBoolean(Constants.USER_INFO_REMEMBER, false)
                .putLong(Constants.USER_INFO_LIMIT_TIME, 0)
                .apply()
        }
    }

    private fun resetRadioButtonImage(drawableId: Int, radioButton: RadioButton) {
        val drawable = resources.getDrawable(drawableId, null)
        drawable.setBounds(0, 0, Util.dip2px(this, 48F), Util.dip2px(this, 48F))
        radioButton.setCompoundDrawables(null, drawable, null, null)
    }

}