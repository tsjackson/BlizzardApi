package com.example.finalprojectremake

import com.example.finalprojectremake.data.BaseRepository
import com.example.finalprojectremake.data.BlizzardApi
import com.example.finalprojectremake.data.Card

class CardRepository(private val api: BlizzardApi) : BaseRepository() {
    fun getCardData(): MutableList<Card>?{

        val cardResponse = safeApiCall(
            call = {api.getAllCardsAsync().await()}
        )
    }
}
