package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

data class TransactionHistoryModel(
    val id: Int,
    val transactionTitle: String,
    val transactionDescription: String,
    val transactionAmount: String,
    val transactionDate: String,
    val image: Int
)

val transactionHistoryList = arrayListOf(
    TransactionHistoryModel(
        1,
        "Booked Ticket",
        "John Wick 3: Parabellum",
        "- $54.00",
        "24 MAY, 2019",
        R.drawable.booked_ticket
    ),
    TransactionHistoryModel(
        1,
        "Transfer Money",
        "Bank Account",
        "+ $60.00",
        "24 MAY, 2019",
        R.drawable.transfer
    ),
    TransactionHistoryModel(
        1,
        "Booked Ticket",
        "King of the Monsters",
        "- $38.00",
        "24 MAY, 2019",
        R.drawable.booked_ticket
    ),
    TransactionHistoryModel(
        1,
        "Booked Ticket",
        "The Secret Life of Pets",
        "- $54.00",
        "24 MAY, 2019",
        R.drawable.booked_ticket
    )
)