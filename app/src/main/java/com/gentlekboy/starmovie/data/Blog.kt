package com.gentlekboy.starmovie.data

import com.gentlekboy.starmovie.R

data class Blog(
    val id: Int,
    val timeStamp: String,
    val title: String,
    val image: Int
)

val blogList = arrayListOf(
    Blog(1, "3 hours ago", "Female Action Stars We Can’t Wait", R.drawable.first_blog_image),
    Blog(2, "2 days ago", "The Best John Wick Action Scenes", R.drawable.second_blog_image),
    Blog(3, "a week ago", "John Wick's Dog", R.drawable.third_blog_image)
)