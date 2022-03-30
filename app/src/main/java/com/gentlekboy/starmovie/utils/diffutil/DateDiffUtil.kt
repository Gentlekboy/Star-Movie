package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.DateModel

/**
 * DiffUtil class for the date recycler view adapter
 */
class DateDiffUtil(
    private val oldList: ArrayList<DateModel>,
    private val newList: ArrayList<DateModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].date != newList[newItemPosition].date -> false
        oldList[oldItemPosition].day != newList[newItemPosition].day -> false
        else -> true
    }
}