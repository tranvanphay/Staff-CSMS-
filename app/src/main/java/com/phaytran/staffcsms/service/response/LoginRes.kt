package com.phaytran.staffcsms.service.response

import com.google.gson.annotations.SerializedName

data class LoginRes(
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("userId")
    val userId: Int
)