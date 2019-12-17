package com.example.finalprojectremake.api

import com.example.finalprojectremake.util.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitFactory {
//    private val authKeyInterceptor = Interceptor { chain ->
//        val newUrl = chain.request().url()
//            .newBuilder()
//            .addQueryParameter("client_id",AppConstants.clientId_api_key)
//            .addQueryParameter("client_secret",AppConstants.clientSecret_api_key)
//            .build()
//        val newRequest = chain.request()
//            .newBuilder()
//            .url(newUrl)
//            .build()
//        chain.proceed(newRequest)
//    }
    //OkHttpClient for sendingURL
    val blizzardAuthKey = OkHttpClient()
        .newBuilder()
        .build()
    //TODO pass authkey from blizzardAuthKey to blizzardCardData
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("AuthToken","authToken")
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }
    val blizzardAuthToken: OkHttpClient? = OkHttpClient()
        .newBuilder()
        .authenticator(TokenAuthenticator())
        .build()
    val blizzardCardData: OkHttpClient? = OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .build()
    fun authRetrofit(): Retrofit = Retrofit.Builder()
        .client(blizzardAuthToken)
        .baseUrl(AppConstants.URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(blizzardCardData)
        .baseUrl(AppConstants.URLWithToken)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
}