package com.bkjcb.base.network

import com.bkjcb.base.Constants.BASE_URL
import com.bkjcb.base.Constants.CALLTIMEOUT
import com.bkjcb.base.Constants.CONTENTTIMEOUT
import com.bkjcb.base.Constants.READTIMEOUT
import com.bkjcb.base.model.SimpleHttpResult
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class NetworkApi {
    fun getRetrofit(service: Class<*>): Retrofit {
        if (retrofitHashMap[mBaseUrl + service.name] != null) {
            return retrofitHashMap[mBaseUrl + service.name]!!
        }
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl(mBaseUrl)
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create())
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofitBuilder.client(
            OkHttpClient.Builder()
                .connectTimeout(CONTENTTIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(READTIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .callTimeout(CALLTIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .build()
        )
        val retrofit = retrofitBuilder.build()
        retrofitHashMap[mBaseUrl + service.name] = retrofit
        return retrofit
    }

    companion object {
        private val retrofitHashMap = HashMap<String, Retrofit>()
        private val mBaseUrl = BASE_URL

        @Volatile
        private var sInstance: NetworkApi? = null
        private fun getInstance(): NetworkApi{
                if (sInstance == null) {
                    synchronized(NetworkApi::class.java) {
                        if (sInstance == null) {
                            sInstance = NetworkApi()
                        }
                    }
                }
                return sInstance!!
            }

        fun <T> getService(service: Class<T>): T {
            return getInstance().getRetrofit(service).create(service)
        }
    }
}