package com.gentlekboy.starmovie.utils

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.Movie

/**
 * DiffUtil class for the home recycler view adapter
 */
class HomeDiffUtil(
    private val oldList: ArrayList<Movie>,
    private val newList: ArrayList<Movie>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].rating != newList[newItemPosition].rating -> false
        oldList[oldItemPosition].title != newList[newItemPosition].title -> false
        oldList[oldItemPosition].genre != newList[newItemPosition].genre -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        else -> true
    }
}