package com.gentlekboy.starmovie.data

import com.gentlekboy.starmovie.R

/**
 * Data class for Movies shown on the Home Screen
 */
data class Movie(
    val id: Int,
    val rating: Float,
    val title: String,
    val genre: String,
    val image: Int
)

//Dummy data for movies on the Home Screen
val movieList = arrayListOf(
    Movie(
        1, 3.5F, "John Wick 3", "Crime | 2hr 10m | R", R.drawable.john_wick
    ),
    Movie(
        2, 4.5F, "Blade Runner", "Action | 2hr 25m | PG-13", R.drawable.blade_runner
    ),
    Movie(
        3, 2.0F, "Alita", "Adventure | 1hr 38m | 18+", R.drawable.alita
    ),
    Movie(
        4, 5.0F, "Avengers", "Action | 2hr 42m | PG-13", R.drawable.avengers
    )
)