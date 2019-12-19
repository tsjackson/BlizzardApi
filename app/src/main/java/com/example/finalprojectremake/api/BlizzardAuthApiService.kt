package com.example.finalprojectremake.api

import com.example.finalprojectremake.data.AuthToken
import com.example.finalprojectremake.util.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BlizzardAuthApiService {
    val blizzardAuthToken: OkHttpClient = OkHttpClient()
        .newBuilder()
        .authenticator(TokenAuthenticator())
        .build()
    fun authRetrofit(): Retrofit = Retrofit.Builder()
        .client(blizzardAuthToken)
        .baseUrl(AppConstants.URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val getAuthToken: Response<AuthToken> = authRetrofit().create(BlizzardApiInterface::class.java).sendApiToken(AppConstants.clientId_api_key,AppConstants.clientSecret_api_key).execute()
}