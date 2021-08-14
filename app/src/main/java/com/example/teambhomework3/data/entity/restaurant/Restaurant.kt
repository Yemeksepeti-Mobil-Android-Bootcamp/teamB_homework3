package com.example.teambhomework3.data.entity.restaurant

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    var restaurantName: String, val restaurantAdress: String,
    val restaurantImage: String, var restaurantNumber: String,
    val restaurantType: String) : Parcelable