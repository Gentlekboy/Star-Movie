package com.gentlekboy.starmovie.data.model

data class TimeModel(
    val id: Int,
    val time: String
)

val timeList = arrayListOf(
    TimeModel(1, "8:30 AM"),
    TimeModel(2, "9:30 AM"),
    TimeModel(3, "10:00 AM"),
    TimeModel(4, "12:30 PM"),
    TimeModel(5, "1:45 PM"),
    TimeModel(6, "2:00 PM"),
)