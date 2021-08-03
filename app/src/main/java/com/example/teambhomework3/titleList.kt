package com.sarikaya.project3

fun titleList(): List<Titles> {
    val titleList = ArrayList<Titles>()
    listOf("Burger King","Dominos","Sbarro","Pizza Hot","Mcdonalds","Mcdonalds","Mcdonalds","Mcdonalds","Mcdonalds","Mcdonalds","Mcdonalds","Mcdonalds").forEach{
        titleList.add(Titles(it))
    }
    return titleList
}