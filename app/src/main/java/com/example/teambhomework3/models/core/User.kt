package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String?,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("profile")
    val profile: Profile?,
    @SerializedName("userAddresses")
    val userAddresses: List<Address>?,
    @SerializedName("orders")
    val orders: List<Order>?,
)
