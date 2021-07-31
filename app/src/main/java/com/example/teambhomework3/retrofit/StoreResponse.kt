package com.example.teambhomework3.retrofit

import com.google.gson.annotations.SerializedName

data class StoreResponse<T>(
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<T>
)

data class DeleteResponse(
    @SerializedName("message")
    val message: String
)
