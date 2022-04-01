package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class NotificationModel(
    val id: Int,
    val image: Int,
    val notification: String,
    val time: String
)

val notificationList = arrayListOf(
    NotificationModel(
        1,
        R.drawable.thumbs,
        "Congrat! You booked John Wick 3 movie ticket successfully.",
        "10:48:25 AM"
    ),
    NotificationModel(
        2,
        R.drawable.bell_image,
        "Hi Morgan. This is just a reminder for your movie today in 13:45 PM.",
        "3 hours ago"
    ),
    NotificationModel(
        3,
        R.drawable.dollar_image,
        "You’ve got an cashback for the past ticket booking.",
        "2 days ago"
    ),
    NotificationModel(
        4,
        R.drawable.percent_image,
        "You just got the discount 30% for booking a movie in this week.",
        "5 days ago"
    ),
    NotificationModel(
        5,
        R.drawable.thumbs,
        "Congrat! You booked John Wick 3 movie ticket successfully.",
        "4 weeks ago"
    ),
)