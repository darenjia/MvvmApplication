package com.bkjcb.gasuserrecord.retrofit

import com.bkjcb.base.model.HttpResult
import com.bkjcb.base.model.SimpleHttpResult
import com.bkjcb.gasuserrecord.model.*
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by DengShuai on 2019/10/24.
 * Description :
 */
interface GasService {
    @POST("rq/push/saveYihuyidang")
    @FormUrlEncoded
    fun saveUserInfo(
        @Field("userId") userId: String?,
        @Field("suoshuqu") suoshuqu: String?,
        @Field("jiedao") jiedao: String?,
        @Field("jiandangriqi") jiandangriqi: String?,
        @Field("yonghuming") yonghuming: String?,
        @Field("fuzeren") fuzeren: String?,
        @Field("dizhi") dizhi: String?,
        @Field("dianhua") dianhua: String?,
        @Field("yingyezhizhao") yingyezhizhao: String?,
        @Field("faren") faren: String?,
        @Field("ranqiguanlizhidu") ranqiguanlizhidu: String?,
        @Field("gongqiqiye") gongqiqiye: String?,
        @Field("gongqiqiyeid") gongqiqiyeid: String?,
        @Field("yongqihetong") yongqihetong: String?,
        @Field("qiandingriqi") qiandingriqi: String?,
        @Field("tiaoyafa") tiaoyafa: String?,
        @Field("tiaoyafa_geshu") tiaoyafa_geshu: String?,
        @Field("lianjieguan") lianjieguan: String?,
        @Field("zaojuleixing_dafeng") zaojuleixing_dafeng: String?,
        @Field("zaojuleixing_gufeng") zaojuleixing_gufeng: String?,
        @Field("xihuobaohu") xihuobaohu: String?,
        @Field("xihuobaohu_geshu") xihuobaohu_geshu: String?,
        @Field("ranqixieloubaojinqi") ranqixieloubaojinqi: String?,
        @Field("qiyeanjianjilu") qiyeanjianjilu: String?,
        @Field("anjianriqi") anjianriqi: String?
    ): Observable<HttpResult>

    @POST("rq/push/saveYihuyidang")
    @FormUrlEncoded
    fun saveUserInfo(@FieldMap hashMap: HashMap<String, String>): Observable<HttpResult>

    @POST("rq/push/updateYihuyidang")
    @FormUrlEncoded
    fun updateUserInfo(@FieldMap hashMap: HashMap<String?, String?>?): Observable<HttpResult>

    @POST("rq/push/saveYihuyidangyinhuan")
    @FormUrlEncoded
    fun saveReviewInfo(@FieldMap hashMap: HashMap<String?, String?>?): Observable<HttpResult>

    @GET("rq/push/getComboList")
    fun getComboList(@Query("type") type: String?): Observable<SimpleHttpResult<GasCompany>>

    @POST("rq/push/getYihuyidangGongzuoList")
    @FormUrlEncoded
    fun getWorkRecords(
        @Field("start") start: Int,
        @Field("limit") limit: Int,
        @Field("suoshuqu") qu: String?,
        @Field("jiedao") jd: String?,
        @Field("name") key: String?,
        @Field("tiaoyafa") filter1: String?,
        @Field("xihuobaohu") filter2: String?,
        @Field("lianjieguan") filter3: String?
    ): Observable<SimpleHttpResult<GasUserRecord>>

    @POST("rq/push/getYihuyidangUserList")
    @FormUrlEncoded
    fun getUserList(@Field("name") key: String): Observable<SimpleHttpResult<GasUserRecord>>

    @POST("rq/push/getYihuyidang")
    @FormUrlEncoded
    fun getUserDetail(@Field("yihuyidangid") id: String?): Observable<SimpleHttpResult<GasRecord>>

    @POST("rq/push/getYihuyidangFuchaList")
    @FormUrlEncoded
    fun getRecordList(
        @Field("yihuyidangid") id: String?,
        @Field("yihuyidangfuchaid") rId: String?
    ): Observable<SimpleHttpResult<ReviewRecord>>

    @GET("rq/push/getYihuyidangTongjifengmianList")
    fun getStatisticData(@Query("suoshuqu") district: String?): Observable<SimpleHttpResult<List<GasStatisticData>>>

    @GET("rq/push/getYihuyidangTongjifengmian")
    fun getStatisticDataSimple(
        @Query("suoshuqu") district: String?,
        @Query("jiandangriqi") date: String?,
        @Query("jiedao") street: String?
    ): Observable<SimpleHttpResult<SimpleHttpResult<GasStatisticData>>>
}