package com.bkjcb.base.model

import com.bkjcb.base.network.HttpRequestStatus
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
class SimpleObservable<T>(private val httpRequestStatus: HttpRequestStatus<T>) : Observer<T> {
    override fun onNext(t: T) {
        httpRequestStatus.requestSuccess(t)
    }

    override fun onError(e: Throwable) {
        httpRequestStatus.requestFailure(e.message)
    }

    override fun onComplete() {
        httpRequestStatus.requestComplete()
    }

    override fun onSubscribe(d: Disposable) {
        httpRequestStatus.requestStart(d)
    }

}