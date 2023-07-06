package com.kevin.dstory.response.login

import com.google.gson.annotations.SerializedName

data class LoginResult(

    @field:SerializedName("token")
    val token: String

)