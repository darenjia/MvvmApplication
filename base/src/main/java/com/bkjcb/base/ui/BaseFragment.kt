package com.bkjcb.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bkjcb.base.loadsir.LoadsirUtil
import com.bkjcb.base.loadsir.OnReLoadListener
import com.bkjcb.base.loadsir.callback.EmptyCallback
import com.bkjcb.base.loadsir.callback.ErrorCallback
import com.bkjcb.base.loadsir.callback.LoadingCallback
import com.kingja.loadsir.core.LoadService
import io.reactivex.disposables.Disposable

/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
abstract class BaseFragment : Fragment() {
    var contentView: View? = null
    var loadService: LoadService<Boolean>? = null
    var disposable: Disposable? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contentView = initView(inflater, container, savedInstanceState)
        initLoadsir(createReloadListener())
        initData()
        return contentView
    }

    abstract fun initData()
    abstract fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    open fun createReloadListener(): OnReLoadListener? {
        return null
    }

    fun initLoadsir(listener: OnReLoadListener?) {
        if (listener != null) {
            loadService = LoadsirUtil.registerNormal(contentView, listener) as LoadService<Boolean>
            contentView = loadService?.loadLayout
        }
    }

    fun showLoading() {
        loadService?.showCallback(LoadingCallback::class.java)
    }

    fun showError() {
        loadService?.showCallback(ErrorCallback::class.java)
    }

    fun showEmpty() {
        loadService?.showCallback(EmptyCallback::class.java)
    }

    fun showResult(result: Boolean) {
        loadService?.showWithConvertor(result)
    }

    fun showContent() {
        loadService?.showSuccess()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable?.dispose()
    }
}