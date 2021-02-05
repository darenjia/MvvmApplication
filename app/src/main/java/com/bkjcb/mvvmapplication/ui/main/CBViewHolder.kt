package com.bkjcb.mvvmapplication.ui.main

import android.view.View
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bkjcb.mvvmapplication.R

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
class CBViewHolder : CBViewHolderCreator {
    override fun createHolder(itemView: View): Holder<*> {
        return LocalImageHolderView(itemView)
    }

    override fun getLayoutId(): Int = R.layout.item_banner_view
}