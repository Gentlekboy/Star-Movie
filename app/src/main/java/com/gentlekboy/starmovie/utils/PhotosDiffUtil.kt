package com.gentlekboy.starmovie.utils

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.Movie
import com.gentlekboy.starmovie.data.Photos

/**
 * DiffUtil class for the photos recycler view adapter
 */
class PhotosDiffUtil(
    private val oldList: ArrayList<Photos>,
    private val newList: ArrayList<Photos>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        else -> true
    }
}