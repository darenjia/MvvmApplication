package com.bkjcb.base.network

import io.reactivex.disposables.Disposable

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
interface HttpRequestStatus<T> {
    fun requestSuccess(t: T?)
    fun requestFailure(msg: String?)
    fun requestStart(d: Disposable)
    fun requestComplete()
}