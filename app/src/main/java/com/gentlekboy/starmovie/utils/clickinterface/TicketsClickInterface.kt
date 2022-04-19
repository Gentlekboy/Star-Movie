package com.gentlekboy.starmovie.utils.clickinterface

interface TicketsClickInterface {
    fun navigateToTicketsDetails(
        movieTitle: Int,
        movieName: String,
        movieShowTime: String,
        movieShowDate: String,
        cinemaSeat: String
    )
}