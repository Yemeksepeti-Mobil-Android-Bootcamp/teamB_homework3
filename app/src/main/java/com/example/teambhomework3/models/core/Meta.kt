package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("total")
    val total: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("current_page")
    val current_page: Int,
    @SerializedName("last_page")
    val last_page: Int,
    @SerializedName("first_page")
    val first_page: Int,
    @SerializedName("first_page_url")
    val first_page_url: String,
    @SerializedName("last_page_url")
    val last_page_url: String,
    @SerializedName("next_page_url")
    val next_page_url: String?,
    @SerializedName("previous_page_url")
    val previous_page_url: String?,

)
