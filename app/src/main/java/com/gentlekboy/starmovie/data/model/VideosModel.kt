package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class VideosModel(
    val id: Int,
    val duration: String,
    val image: Int
)

val videoList = arrayListOf(
    VideosModel(1, "2:13", R.drawable.first_video),
    VideosModel(2, "2:13", R.drawable.second_video),
    VideosModel(3, "2:13", R.drawable.third_video)
)