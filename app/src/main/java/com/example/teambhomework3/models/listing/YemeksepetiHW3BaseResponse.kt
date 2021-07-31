package com.example.teambhomework3.models.listing

import com.example.teambhomework3.models.core.Meta
import com.google.gson.annotations.SerializedName

data class YemeksepetiHW3BaseListingResponse<T>(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("data")
    val data: List<T>
)