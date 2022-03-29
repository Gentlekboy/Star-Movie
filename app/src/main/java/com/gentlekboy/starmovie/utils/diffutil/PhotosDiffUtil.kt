package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.PhotosModel

/**
 * DiffUtil class for the photos recycler view adapter
 */
class PhotosDiffUtil(
    private val oldList: ArrayList<PhotosModel>,
    private val newList: ArrayList<PhotosModel>
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