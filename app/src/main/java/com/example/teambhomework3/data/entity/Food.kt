package com.example.teambhomework3.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(val foodName: String, val foodImage: String, val foodPrice: String, val foodDescription: String) : Parcelable