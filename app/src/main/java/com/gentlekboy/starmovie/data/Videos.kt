package com.gentlekboy.starmovie.data

import com.gentlekboy.starmovie.R

data class Videos(
    val id: Int,
    val duration: String,
    val image: Int
)

val videoList = arrayListOf(
    Videos(1, "2:13", R.drawable.first_video),
    Videos(2, "2:13", R.drawable.second_video),
    Videos(3, "2:13", R.drawable.third_video)
)