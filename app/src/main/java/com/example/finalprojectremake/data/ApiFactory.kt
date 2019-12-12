package com.example.finalprojectremake.data

import com.example.finalprojectremake.util.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {

    private val authInterceptor = Interceptor {chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("client_id",AppConstants.clientId_api_key)
            .addQueryParameter("client_secret",AppConstants.clientSecret_api_key)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
    chain.proceed(newRequest) }

    //OkHttpClient for building http request url
    private val blizzardClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(blizzardClient)
        .baseUrl(AppConstants.URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}