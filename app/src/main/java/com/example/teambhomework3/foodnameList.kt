package com.sarikaya.project3

fun foodNameList(): List<FoodNames>{
    val foodNameList = ArrayList<FoodNames>()
    listOf("Hamburger","CheeseBurger","BBQBurger","TexasBurger").forEach {
        foodNameList.add(FoodNames((it)))
    }
    return foodNameList
}