package com.example.teambhomework3.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(val restaurantName: String, val restaurantAdress: String,
                      val restaurantImage: String, val restaurantNumber: String,
                      val restaurantType: String) : Parcelable