package com.bkjcb.base.model

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
class SimpleHttpResult<T> : HttpResult() {
    val datas: T? = null
    val totalCount: Int = 0

}