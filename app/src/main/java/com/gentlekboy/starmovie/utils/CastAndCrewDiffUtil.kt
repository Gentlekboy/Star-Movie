package com.gentlekboy.starmovie.utils

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.CastAndCrew
import com.gentlekboy.starmovie.data.Movie

/**
 * DiffUtil class for recycler view adapters
 */
class CastAndCrewDiffUtil(
    private val oldList: ArrayList<CastAndCrew>,
    private val newList: ArrayList<CastAndCrew>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].realName != newList[newItemPosition].realName -> false
        oldList[oldItemPosition].movieName != newList[newItemPosition].movieName -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        else -> true
    }
}