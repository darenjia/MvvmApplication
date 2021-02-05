package com.bkjcb.mvvmapplication.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.bigkoo.convenientbanner.adapter.CBPageAdapter
import com.bigkoo.convenientbanner.adapter.CBPageAdapterHelper
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bkjcb.mvvmapplication.R
import com.bkjcb.mvvmapplication.adapter.MenuGridAdapter
import com.bkjcb.mvvmapplication.databinding.MainFragmentBinding
import com.bkjcb.mvvmapplication.repository.MenuRepository
import com.bkjcb.mvvmapplication.viewmodel.MenuViewModel

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.getDataString()?.observe(this, Observer { t -> t.length })
        val menuViewModel: MenuViewModel = MenuViewModel(MenuRepository(1), activity!!.application)
        val gridAdapter: MenuGridAdapter = MenuGridAdapter(menuViewModel)
        binding.mainMenuGrid.adapter = gridAdapter
        initBanner()
    }

    private fun initBanner(){
        val list:ArrayList<String> = ArrayList()
        list.add("https://bucket-shgas.oss-cn-shanghai.aliyuncs.com/portalWebSite/static/home9.jpg")
        binding.convenientBanner.setPages(CBViewHolder(),list)
    }
}