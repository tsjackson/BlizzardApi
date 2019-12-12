package com.example.finalprojectremake.data

import okhttp3.Call
import retrofit2.http.Field
import retrofit2.http.POST


interface HearthstoneApi {
    @POST("/token?grant_type=client_credentials")
    fun insertUser(
        @Field("user") user: String?,
        @Field("password") password: String?
    ): Call<>
}