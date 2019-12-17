package com.example.finalprojectremake.api

import com.example.finalprojectremake.util.AppConstants
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        return response.request().newBuilder()
            .header(AppConstants.clientId_api_key,AppConstants.clientSecret_api_key)
            .build()
    }
}