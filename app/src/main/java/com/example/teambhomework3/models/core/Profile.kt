package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("mobileNumber")
    val mobileNumber: String?,
    @SerializedName("avatarUrl")
    val avatarUrl: String?,
)
