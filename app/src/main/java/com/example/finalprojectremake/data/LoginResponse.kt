package com.example.finalprojectremake.data

import com.example.finalprojectremake.util.AppConstants
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("userId")
    lateinit var userId: String
    @SerializedName("UserPassword")
    lateinit var  password: String

    fun LoginResponse(){
        this.userId = AppConstants.clientId_api_key
        this.password = AppConstants.clientSecret_api_key
    }
}
