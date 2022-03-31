package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class ExtraItemModel(
    val id: Int,
    val name: String,
    val price: String,
    val image: Int
)

val extraItemList = arrayListOf(
    ExtraItemModel(1, "Coca cola", "$4.00", R.drawable.coke),
    ExtraItemModel(2, "Pepsi", "$4.00", R.drawable.pepsi),
    ExtraItemModel(3, "7Up", "$3.00", R.drawable.seven_up),
    ExtraItemModel(4, "Pop corn", "$5.00", R.drawable.popcorn),
)