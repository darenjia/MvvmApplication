package com.bkjcb.base.utils

import com.bkjcb.base.R
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * Created by DengShuai on 2021/2/2.
 * Description :
 */
object GlideUtil {
    fun getRequestOption(): RequestOptions {
        return RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.error_image).placeholder(R.drawable.vector_drawable_picture_loding)
    }
}