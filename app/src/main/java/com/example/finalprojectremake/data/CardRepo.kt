package com.example.finalprojectremake.data

import com.example.finalprojectremake.api.BlizzardApiInterface
import com.example.finalprojectremake.api.BlizzardAuthApiService.getAuthToken

public class CardRepo(private val apiInterface: BlizzardApiInterface) : BaseRepo() {
    suspend fun getCardData(): MutableList<Card>? {
        val authToken = getAuthToken
        authToken.run {  }
        return safeApiCall(
            //await the result of deferred type
            call = { apiInterface.fetchCardDataAsync(getAuthToken.toString()).await() },
            error = "Error Fetching Card Data"
        //convert to mutable list
        )?.cards?.toMutableList()
    }
}