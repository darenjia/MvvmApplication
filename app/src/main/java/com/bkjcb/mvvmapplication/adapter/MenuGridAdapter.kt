package com.bkjcb.mvvmapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bkjcb.mvvmapplication.databinding.ItemMenuViewBinding
import com.bkjcb.mvvmapplication.viewmodel.MenuViewModel

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
class MenuGridAdapter(val viewModel: MenuViewModel) : BaseAdapter() {

    override fun getCount(): Int {
        return viewModel.getMenuItemList().value!!.size
    }

    override fun getItem(position: Int): Any = viewModel.getMenuItemList().value!![position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder = ViewHolder(
            ItemMenuViewBinding.inflate(
                LayoutInflater.from(viewModel.getApplication()),
                parent,
                false
            )
        )
        viewHolder.binding.menu = viewModel.getMenuItemList().value!![position]
        return viewHolder.getView()

    }
}

class ViewHolder(val binding: ItemMenuViewBinding) {
    fun getView(): View = binding.root
}