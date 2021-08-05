package com.example.teambhomework3.entity

data class User(val name:String, val email:String,
                val profileImage:String = "", val joinedData: String = "",
                val lastOrders: ArrayList<String>?, val adress: ArrayList<Adress>?) {
}