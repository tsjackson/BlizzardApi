package com.example.finalprojectremake.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectremake.R
import com.example.finalprojectremake.api.APIInterface
import com.example.finalprojectremake.api.RetrofitFactory
import com.example.finalprojectremake.util.AppConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitFactory.authRetrofit().create(APIInterface::class.java).getToken(AppConstants.clientId_api_key,AppConstants.clientSecret_api_key)
    }
}
