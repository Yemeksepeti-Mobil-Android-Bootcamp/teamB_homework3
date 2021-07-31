package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("id")
    val id: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("neighborhood")
    val neighborhood: String,
    @SerializedName("street")
    val street: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
)
