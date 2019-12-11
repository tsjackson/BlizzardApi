package com.example.finalprojectremake.data

import com.example.finalprojectremake.util.AppConstants
import okhttp3.Interceptor

object ApiFactory {
    private val authInterceptor = Interceptor {chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("client_id",AppConstants.clientId_api_key)
            .addQueryParameter("client_secret",AppConstants.clientSecret_api_key)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(AppConstants.URL)
            .build()
    chain.proceed(newRequest) }
}