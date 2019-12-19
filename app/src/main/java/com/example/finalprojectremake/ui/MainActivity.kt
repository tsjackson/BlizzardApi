package com.example.finalprojectremake.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalprojectremake.R
import com.example.finalprojectremake.data.Card

class MainActivity : AppCompatActivity() {
    val customViewModel by lazy {
        ViewModelProvider(this).get(CardViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customViewModel.getLatestCards()
        customViewModel.getCards().observe(this,
            Observer<MutableList<Card>> { })

    }
}
