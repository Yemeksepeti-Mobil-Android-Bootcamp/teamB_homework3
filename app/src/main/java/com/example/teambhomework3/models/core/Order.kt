package com.example.teambhomework3.models.core

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("restaurantId")
    val restaurantId: Int,
    @SerializedName("orderNote")
    val orderNote: String,
    @SerializedName("orderPaymentMethod")
    val orderPaymentMethod: PaymentMethods?,
    @SerializedName("restaurant")
    val restaurant: Restaurant?,
    @SerializedName("orderFoods")
    val orderFoods: List<Food>?,
    @SerializedName("user")
    val user: User?,
){
    enum class PaymentMethods {
        CREDIT_CARD,
        CASH,
        COUPON,
    }
}