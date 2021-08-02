package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: Int,
    @SerializedName("typeOfRestaurant")
    val typeOfRestaurant: String,
    @SerializedName("logoUrl")
    val logoUrl: String,
    @SerializedName("restaurantAddress")
    val restaurantAddress: List<Address>?,
    @SerializedName("restaurantFoods")
    val restaurantFoods: List<Food>?,
)
