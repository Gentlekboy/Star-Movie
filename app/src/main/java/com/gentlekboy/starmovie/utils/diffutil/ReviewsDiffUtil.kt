package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.ReviewsModel

/**
 * DiffUtil class for the reviews recycler view adapter
 */
class ReviewsDiffUtil(
    private val oldList: ArrayList<ReviewsModel>,
    private val newList: ArrayList<ReviewsModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        oldList[oldItemPosition].name != newList[newItemPosition].name -> false
        oldList[oldItemPosition].date != newList[newItemPosition].date -> false
        oldList[oldItemPosition].rating != newList[newItemPosition].rating -> false
        oldList[oldItemPosition].review != newList[newItemPosition].review -> false
        else -> true
    }
}