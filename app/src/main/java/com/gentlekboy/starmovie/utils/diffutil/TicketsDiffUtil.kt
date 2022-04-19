package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.TicketsModel

/**
 * DiffUtil class for the tickets recycler view adapter
 */
class TicketsDiffUtil(
    private val oldList: ArrayList<TicketsModel>,
    private val newList: ArrayList<TicketsModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].movieName != newList[newItemPosition].movieName -> false
        oldList[oldItemPosition].movieShowTime != newList[newItemPosition].movieShowTime -> false
        oldList[oldItemPosition].movieShowDate != newList[newItemPosition].movieShowDate -> false
        oldList[oldItemPosition].cinemaSeat != newList[newItemPosition].cinemaSeat -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        else -> true
    }
}