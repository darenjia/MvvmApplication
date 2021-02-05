package com.bkjcb.gasuserrecord.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bkjcb.base.network.HttpRequestStatus
import com.bkjcb.base.loadsir.OnReLoadListener
import com.bkjcb.base.model.SimpleHttpResult
import com.bkjcb.base.ui.BaseFragment
import com.bkjcb.gasuserrecord.databinding.FragmentStatisticTableBinding
import com.bkjcb.gasuserrecord.model.GasStatisticData
import com.bkjcb.gasuserrecord.repository.StatisticRepository
import com.bkjcb.gasuserrecord.util.ChartUtil
import com.bkjcb.gasuserrecord.viewmodel.StatisticViewModel
import io.reactivex.disposables.Disposable

/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
class StatisticTableFragment : BaseFragment(),
    HttpRequestStatus<SimpleHttpResult<List<GasStatisticData>>> {
    lateinit var binding: FragmentStatisticTableBinding
    private lateinit var viewModel: StatisticViewModel
    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun createReloadListener(): OnReLoadListener? {
        return object : OnReLoadListener {
            override fun onReload() {

            }
        }
    }

    override fun initData() {
        viewModel = ViewModelProvider(this).get(StatisticViewModel::class.java)
        viewModel.tableData.observe(this, Observer {
            initChart(it)
        })
        showLoading()
        StatisticRepository.get().getStatisticData(this)
    }

    private fun initChart(list: List<GasStatisticData>) {
        ChartUtil.initPieChart(binding.gasChart, list)
        ChartUtil.initBarChart(binding.gasChart2, list)
    }

    override fun requestSuccess(t: SimpleHttpResult<List<GasStatisticData>>?) {
        if (t != null && t.pushState == 200) {
            if (t.datas == null || t.datas!!.isEmpty()) {
                showEmpty()
            } else {
                viewModel.setChartNewData(t.datas)
            }

        } else {
            showError()
        }
    }

    override fun requestFailure(msg: String?) {
        showError()
    }

    override fun requestStart(d: Disposable) {
        showLoading()
        disposable = d
    }

    override fun requestComplete() {
        showContent()
    }
}