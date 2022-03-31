package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.ExtraItemModel

/**
 * DiffUtil class for the extra item recycler view adapter
 */
class ExtraItemDiffUtil(
    private val oldList: ArrayList<ExtraItemModel>,
    private val newList: ArrayList<ExtraItemModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        oldList[oldItemPosition].name != newList[newItemPosition].name -> false
        oldList[oldItemPosition].price != newList[newItemPosition].price -> false
        else -> true
    }
}