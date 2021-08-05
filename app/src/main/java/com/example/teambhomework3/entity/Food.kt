package com.example.teambhomework3.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(val foodName: String, val foodImage: String, val foodPrice: String) : Parcelable {}