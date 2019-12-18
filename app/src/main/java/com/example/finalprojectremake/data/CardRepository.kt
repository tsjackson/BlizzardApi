package com.example.finalprojectremake.data

import com.example.finalprojectremake.api.BlizzardApiInterface
import com.example.finalprojectremake.api.BlizzardAuthApiService.getAuthToken

public class CardRepository(private val apiInterface: BlizzardApiInterface) : BaseRepository() {
    suspend fun getCardData(): MutableList<Card>? {
        return safeApiCall(
            //await the result of deferred type
            call = { apiInterface.fetchCardDataAsync(getAuthToken.toString()).await() },
            error = "Error Fetching Card Data"
        //convert to mutable list
        )?.cards?.toMutableList()
    }
}