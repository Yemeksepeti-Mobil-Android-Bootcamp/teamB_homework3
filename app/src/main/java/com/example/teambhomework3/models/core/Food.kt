package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("foodRestaurants")
    val foodRestaurants: List<Restaurant>?,
)
