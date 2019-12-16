package com.example.finalprojectremake.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

data class AuthToken(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)

data class Card(
    val armor: Int,
    val artistName: String,
    val attack: Int,
    val cardSetId: Int,
    val cardTypeId: Int,
    val childIds: List<Int>,
    val classId: Int,
    val collectible: Int,
    val cropImage: String,
    val flavorText: String,
    val health: Int,
    val id: Int,
    val image: String,
    val imageGold: String,
    val keywordIds: List<Int>,
    val manaCost: Int,
    val minionTypeId: Int,
    val multiClassIds: List<Any>,
    val name: String,
    val parentId: Int,
    val rarityId: Int,
    val slug: String,
    val text: String
)
data class CardDataResponse(
    val cards: List<Card>
)
interface BlizzardApi{
    @GET("/cards?locale=en_US&{access_token}")
    fun getAllCardsAsync(): Deferred<Response<CardDataResponse>>
}
