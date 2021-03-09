package com.phaytran.staffcsms.service.request

import com.google.gson.annotations.SerializedName

data class LoginReq(
    @SerializedName("username")
    val userName: String,
    @SerializedName("password")
    val password: String
)