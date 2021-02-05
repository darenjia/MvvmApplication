package com.bkjcb.gasuserrecord.repository

import com.bkjcb.base.network.HttpRequestStatus
import com.bkjcb.base.model.SimpleHttpResult
import com.bkjcb.base.model.SimpleObservable
import com.bkjcb.base.network.NetworkApi
import com.bkjcb.gasuserrecord.model.GasStatisticData
import com.bkjcb.gasuserrecord.retrofit.GasService
import io.reactivex.schedulers.Schedulers

/**
 * Created by DengShuai on 2021/2/1.
 * Description :
 */
class StatisticRepository {
    companion object {
        private var instance: StatisticRepository? = null
            get() {
                if (field == null) {
                    field = StatisticRepository()
                }
                return field
            }

        fun get(): StatisticRepository {
            return instance!!
        }
    }

    fun getStatisticData(requestStatus: HttpRequestStatus<SimpleHttpResult<List<GasStatisticData>>>) {
        NetworkApi.getService(GasService::class.java)
            .getStatisticData("")
            .subscribeOn(Schedulers.io())
            .subscribe(SimpleObservable(requestStatus))
    }
}