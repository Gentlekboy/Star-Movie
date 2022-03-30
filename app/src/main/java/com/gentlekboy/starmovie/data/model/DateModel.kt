package com.gentlekboy.starmovie.data.model

data class DateModel(
    val id: Int,
    val date: String,
    val day: String
)

val dateList = arrayListOf(
    DateModel(1, "Today", "WED"),
    DateModel(2, "23 May", "THU"),
    DateModel(3, "24 May", "FRI"),
    DateModel(4, "25 May", "SAT"),
    DateModel(5, "26 May", "SUN"),
    DateModel(6, "27 May", "MON"),
    DateModel(7, "28 May", "TUE"),
)