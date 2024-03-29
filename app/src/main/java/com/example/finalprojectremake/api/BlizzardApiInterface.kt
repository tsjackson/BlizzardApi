package com.example.finalprojectremake.api

import com.example.finalprojectremake.data.AuthToken
import com.example.finalprojectremake.data.CardData
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface BlizzardApiInterface {
    @POST("/token?grant_type=client_credentials")
    fun sendApiToken(
        @Field("clientId_api_key") clientId_api_key: String,
        @Field("clientSecret_api_key") clientSecret_api_key: String
    ): Call <AuthToken>

    @GET("/cards?locale=en_US&{access_token}")
    fun fetchCardDataAsync(@Path("access_token") access_token: String): Deferred<Response<CardData>>
}