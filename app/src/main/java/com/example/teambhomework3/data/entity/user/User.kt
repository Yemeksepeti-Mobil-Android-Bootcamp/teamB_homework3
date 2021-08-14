package com.example.teambhomework3.data.entity.user

import com.example.teambhomework3.data.entity.address.Adress
import com.example.teambhomework3.data.entity.order.Order

data class User(
    val name: String,
    val email: String,
    val profileImage: String = "",
    val joinedDate: String = "",
    val lastOrders: Order?,
    val adress: Adress?
)