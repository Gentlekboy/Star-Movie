package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class ReviewsModel(
    val id: Int,
    val name: String,
    val date: String,
    val rating: Float,
    val image: Int,
    val review: String
)

val reviewsList = arrayListOf(
    ReviewsModel(
        1,
        "Keanu Reeves",
        "May 20, 2019",
        4.5F,
        R.drawable.keanu_reeves,
        "John Wick Chapter 3 offers great action and a more in-depth at his World in comparison to the first two entries."
    ),
    ReviewsModel(
        2,
        "Halle Berry",
        "January 24, 2019",
        5F,
        R.drawable.halle_berry,
        "Great movie, lots of action, extremely gory, and in some scenes even funny!"
    ),
    ReviewsModel(
        3,
        "Laurence Fishburne",
        "September 10, 2019",
        4.5F,
        R.drawable.laurence_lishburne,
        "I could some of the punches being thrown getting faked but outside of that and great acton movie."
    ),
    ReviewsModel(
        4,
        "Mark Dacascos",
        "February 26, 2018",
        3.5F,
        R.drawable.mark_dacascos,
        "I could some of the punches being thrown getting faked but outside of that and great acton movie."
    ),
    ReviewsModel(
        5,
        "Asia Kate Dillon",
        "August 11, 2022",
        4.5F,
        R.drawable.asia_kate_dillon,
        "Great movie, lots of action, extremely gory, and in some scenes even funny!"
    ),
    ReviewsModel(
        6,
        "Lance Reddick",
        "December 21, 2009",
        5F,
        R.drawable.lance_reddick,
        "John Wick Chapter 3 offers great action and a more in-depth at his World in comparison to the first two entries. "
    ),
    ReviewsModel(
        7,
        "Anjelica Huston",
        "October 29, 2020",
        4.5F,
        R.drawable.anjelica_huston,
        "John Wick Chapter 3 offers great action and a more in-depth at his World in comparison to the first two entries. "
    ),
    ReviewsModel(
        8,
        "Margaret Daly",
        "November 30, 2009",
        4.5F,
        R.drawable.margaret_daly,
        "Great movie, lots of action, extremely gory, and in some scenes even funny!"
    ),
    ReviewsModel(
        9,
        "Jerome Flynn",
        "March 15, 2018",
        5F,
        R.drawable.jerome_flynn,
        "I could some of the punches being thrown getting faked but outside of that and great acton movie."
    )
)