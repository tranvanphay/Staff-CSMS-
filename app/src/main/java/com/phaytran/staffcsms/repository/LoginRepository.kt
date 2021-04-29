package com.phaytran.staffcsms.repository

import android.app.Application
import android.util.Log
import com.phaytran.staffcsms.service.APIClient
import com.phaytran.staffcsms.service.apiInterface.UserAPI
import com.phaytran.staffcsms.service.request.LoginReq
import com.phaytran.staffcsms.service.response.LoginRes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(val application: Application) {

    fun doLogin(loginReq:LoginReq):LoginRes{
        Log.e("Phaydev:: ",loginReq.userName + loginReq.password)
        var res = LoginRes(true,-1)
        APIClient.client!!.create(UserAPI::class.java).login(loginReq).enqueue(object : Callback<LoginRes>{
            override fun onResponse(call: Call<LoginRes>, response: Response<LoginRes>) {
                if(response.isSuccessful){
                    res = response.body()!!
                }else{
                    Log.e("Phaydev:: ","Login failed")
                }
            }

            override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                Log.e("Phaydev:: ","Login failed")
            }
        })
        return res
    }
}