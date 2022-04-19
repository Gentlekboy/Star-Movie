package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class TicketsModel(
    val id: Int,
    val movieName: String,
    val movieShowTime: String,
    val movieShowDate: String,
    val cinemaSeat: String,
    val image: Int
)

val ticketsList = arrayListOf(
    TicketsModel(
        1,
        "John Wick 3: Parabellum",
        "8:30 - 10:00 AM",
        "Friday 24 May, 2019",
        "Seat: E4,E5",
        R.drawable.john_wick
    ),
    TicketsModel(
        2,
        "Captain Marvel",
        "8:30 - 10:00 AM",
        "Friday 24 May, 2019",
        "Seat: E4,E5",
        R.drawable.blade_runner
    ),
    TicketsModel(
        3,
        "Alita",
        "8:30 - 10:00 AM",
        "Friday 24 May, 2019",
        "Seat: E4,E5",
        R.drawable.alita
    ),
    TicketsModel(
        4,
        "Avengers",
        "8:30 - 10:00 AM",
        "Friday 24 May, 2019",
        "Seat: E4,E5",
        R.drawable.avengers
    ),
)