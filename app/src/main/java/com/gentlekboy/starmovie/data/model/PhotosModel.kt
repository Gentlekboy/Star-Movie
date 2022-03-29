package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class PhotosModel(
    val id: Int,
    val image: Int
)

val photosList = arrayListOf(
    PhotosModel(1, R.drawable.first_image),
    PhotosModel(2, R.drawable.second_image),
    PhotosModel(3, R.drawable.third_image)
)