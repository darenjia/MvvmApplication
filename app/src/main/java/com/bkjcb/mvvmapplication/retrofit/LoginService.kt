package com.bkjcb.mvvmapplication.retrofit

import com.bkjcb.base.model.SimpleHttpResult
import com.bkjcb.mvvmapplication.model.User
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by DengShuai on 2021/2/4.
 * Description :
 */
interface LoginService {

    @POST("/rq/push/getLoginUser")
    @FormUrlEncoded
    fun getLoginUser(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): Observable<SimpleHttpResult<User>>

}