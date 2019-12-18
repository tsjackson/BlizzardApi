package com.example.finalprojectremake.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalprojectremake.api.BlizzardApiService
import com.example.finalprojectremake.data.Card
import com.example.finalprojectremake.data.CardRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CardViewModel : ViewModel(){
    //create a new job
    private val parentJob = Job()
    //create a coroutine context with the job and the dispatcher
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Default
    // create a coroutine scope with the coroutine context
    private val  scope = CoroutineScope(coroutineContext)
    //initialize card CardRepo
    private val cardRepository: CardRepo = CardRepo(BlizzardApiService.blizzardApi)
    //live data that will be populated as cards update
    private val cardLiveData= MutableLiveData<MutableList<Card>>()
    fun getLatestCards(){
        //launch the coroutine scope
        scope.launch {
            //get latest cards from the card repo
            val latestCards = cardRepository.getCardData()
            //post the value inside live data
            cardLiveData.postValue(latestCards)
        }
    }
    fun cancelRequest()= coroutineContext.cancel()
}