package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.NotificationModel

/**
 * DiffUtil class for the notifications recycler view adapter
 */
class NotificationDiffUtil(
    private val oldList: ArrayList<NotificationModel>,
    private val newList: ArrayList<NotificationModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        oldList[oldItemPosition].notification != newList[newItemPosition].notification -> false
        oldList[oldItemPosition].time != newList[newItemPosition].time -> false
        else -> true
    }
}