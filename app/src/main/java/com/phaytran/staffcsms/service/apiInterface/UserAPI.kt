package com.phaytran.staffcsms.service.apiInterface

import com.phaytran.staffcsms.service.request.LoginReq
import com.phaytran.staffcsms.service.response.LoginRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("user/login")
    fun login(@Body req:LoginReq) : Call<LoginRes>
}