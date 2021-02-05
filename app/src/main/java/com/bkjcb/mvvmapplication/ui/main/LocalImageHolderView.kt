package com.bkjcb.mvvmapplication.ui.main

import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder
import com.bkjcb.base.utils.GlideUtil
import com.bkjcb.mvvmapplication.R

import com.bumptech.glide.Glide

class LocalImageHolderView(itemView: View) : Holder<String>(itemView) {
    private lateinit var imageView: ImageView
    override fun initView(itemView: View) {
        imageView = itemView.findViewById(R.id.banner_item)
    }

    override fun updateUI(data: String?) {
        Glide.with(itemView.context).load(data).apply(GlideUtil.getRequestOption())
            .into(imageView)
    }
}