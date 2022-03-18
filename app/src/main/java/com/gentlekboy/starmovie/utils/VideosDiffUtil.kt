package com.gentlekboy.starmovie.utils

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.Videos

/**
 * DiffUtil class for the videos recycler view adapter
 */
class VideosDiffUtil(
    private val oldList: ArrayList<Videos>,
    private val newList: ArrayList<Videos>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        oldList[oldItemPosition].duration != newList[newItemPosition].duration -> false
        else -> true
    }
}