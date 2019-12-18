package com.example.finalprojectremake.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectremake.R

class CardViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
    val cardImg: ImageView

    init {
        cardImg = itemView.findViewById(R.id.cardImage)
    }
}