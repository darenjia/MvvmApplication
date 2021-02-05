package com.bkjcb.base.loadsir

import com.bkjcb.base.loadsir.callback.EmptyCallback
import com.bkjcb.base.loadsir.callback.ErrorCallback
import com.bkjcb.base.loadsir.callback.LoadingCallback
import com.bkjcb.base.model.SimpleHttpResult
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.Convertor
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir

/**
 * Created by DengShuai on 2020/7/10.
 * Description :
 */
object LoadsirUtil {
    fun initLoadsir() {
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())
            .addCallback(EmptyCallback())
            .addCallback(ErrorCallback())
            .setDefaultCallback(LoadingCallback::class.java) //设置默认状态页
            .commit()
    }

    fun register(target: Any?, onReloadListener: OnReLoadListener?): LoadService<*> {
        return LoadSir.getDefault().register(
            target,
            Callback.OnReloadListener {
                onReloadListener?.onReload()
            },
            Convertor<SimpleHttpResult<*>> {
                if (it.pushState == 200) {
                    return@Convertor if (it.datas == null) {
                        EmptyCallback::class.java
                    } else {
                        SuccessCallback::class.java
                    }
                }
                ErrorCallback::class.java
            })
    }

    fun registerNormal(target: Any?, onReloadListener: OnReLoadListener?): LoadService<*>? {
        return LoadSir.getDefault().register(
            target,
            Callback.OnReloadListener {
                onReloadListener?.onReload()
            },
            Convertor<Boolean> { result -> if (result) SuccessCallback::class.java else EmptyCallback::class.java })
    }
}