package com.bkjcb.mvvmapplication.adapter

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bkjcb.mvvmapplication.R

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
@BindingAdapter("isTintColor")
fun BindingImageTint(view: ImageView, isTint: Boolean) {
    if (isTint) {
        view.imageTintList = ColorStateList.valueOf(view.resources.getColor(R.color.colorTextForth))
    }
}

@BindingAdapter("imageRes")
fun BindingImageRes(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}