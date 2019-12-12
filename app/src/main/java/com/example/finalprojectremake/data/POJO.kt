package com.example.finalprojectremake.data

interface POJO {
    data class authToken(
        val access_token: String,
        val expires_in: Int,
        val token_type: String
    )
}