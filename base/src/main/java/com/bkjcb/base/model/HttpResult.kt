package com.bkjcb.base.model

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
open class HttpResult() {
    var pushState: Int = 0
    var pushMsg: String? = null
    var pushTime: String? = null

    constructor(pushState: Int, pushMsg: String?, pushTime: String?) : this() {
        this.pushState = pushState
        this.pushMsg = pushMsg
        this.pushTime = pushTime
    }
}
