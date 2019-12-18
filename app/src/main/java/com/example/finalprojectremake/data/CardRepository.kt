package com.example.finalprojectremake.data

import com.example.finalprojectremake.api.BlizzardApiInterface

public class CardRepository(private val apiInterface: BlizzardApiInterface) : BaseRepository() {
    suspend fun getCardData(): MutableList<Card>? {
        return safeApiCall(
            //await the result of deferred type
            call = { apiInterface.fetchCardDataAsync("").await() },
            error = "Error Fetching Card Data"
        //convert to mutable list
        )?.cards?.toMutableList()
    }
}