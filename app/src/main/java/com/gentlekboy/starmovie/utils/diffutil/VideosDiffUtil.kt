package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.VideosModel

/**
 * DiffUtil class for the videos recycler view adapter
 */
class VideosDiffUtil(
    private val oldList: ArrayList<VideosModel>,
    private val newList: ArrayList<VideosModel>
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