package com.bkjcb.base.loadsir

import com.bkjcb.base.model.SimpleHttpResult
import com.kingja.loadsir.callback.Callback.OnReloadListener

/**
 * Created by DengShuai on 2020/7/10.
 * Description :
 */
interface LoadsirInter {
    fun initLoadsir(type: Int, view: Any?, listener: OnReloadListener?)
    fun showLoading()
    fun showError()
    fun showEmpty()
    fun showResult(result: SimpleHttpResult<*>?)
    fun showResult(result: Boolean)
    fun showContent()
}