package com.bkjcb.gasuserrecord.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bkjcb.gasuserrecord.model.GasStatisticData
import com.github.mikephil.charting.data.PieEntry

/**
 * Created by DengShuai on 2021/2/3.
 * Description :
 */
class StatisticViewModel : ViewModel() {
    private val data: MutableLiveData<List<GasStatisticData>> = MutableLiveData()
    val tableData: MutableLiveData<List<GasStatisticData>> =
        if (data.value?.size == 0) {
            MutableLiveData(data.value?.get(0)!!.childrens!!)
        } else {
            data
        }

    fun setChartNewData(list: List<GasStatisticData>?) {
        data.postValue(list)
    }
}