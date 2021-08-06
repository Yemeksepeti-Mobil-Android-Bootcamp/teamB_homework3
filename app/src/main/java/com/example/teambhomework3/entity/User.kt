package com.example.teambhomework3.entity

data class User(
    val name: String,
    val email: String,
    val profileImage: String = "",
    val joinedDate: String = "",
    val lastOrders: Order?,
    val adress: Adress?
)