package com.bkjcb.base.loadsir.callback

import com.bkjcb.base.R
import com.kingja.loadsir.callback.Callback

/**
 * Created by DengShuai on 2020/7/10.
 * Description :
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.empty_view
    }
}