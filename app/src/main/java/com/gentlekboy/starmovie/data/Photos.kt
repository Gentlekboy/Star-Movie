package com.gentlekboy.starmovie.data

import com.gentlekboy.starmovie.R

data class Photos(
    val id: Int,
    val image: Int
)

val photosList = arrayListOf(
    Photos(1, R.drawable.first_image),
    Photos(2, R.drawable.second_image),
    Photos(3, R.drawable.third_image)
)