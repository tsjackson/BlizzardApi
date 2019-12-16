package com.example.finalprojectremake.util

import com.example.finalprojectremake.BuildConfig

object AppConstants {
    var clientId_api_key: String = BuildConfig.clientId_api_key
    var clientSecret_api_key: String = BuildConfig.clientSecret_api_key
    const val URL = "https://us.battle.net/oauth/token?grant_type=client_credentials"
    const val URLWithToken ="https://us.api.blizzard.com/hearthstone/cards?locale=en_US&access_token"
}