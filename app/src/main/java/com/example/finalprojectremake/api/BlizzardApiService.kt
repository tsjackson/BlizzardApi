package com.example.finalprojectremake.api

import com.example.finalprojectremake.util.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BlizzardApiService {
    //TODO pass authkey from blizzardAuthKey to blizzardCardData
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("AuthToken","PlaceHolder")
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }

    val blizzardCardData: OkHttpClient? = OkHttpClient()
        .newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .client(blizzardCardData)
        .baseUrl(AppConstants.URLWithToken)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val BLIZZARD_BLIZZARD_API: BlizzardApiInterface = getRetrofit().create(BlizzardApiInterface::class.java)
}