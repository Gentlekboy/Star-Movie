package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.BlogModel

/**
 * DiffUtil class for the blog recycler view adapter
 */
class BlogDiffUtil(
    private val oldList: ArrayList<BlogModel>,
    private val newList: ArrayList<BlogModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        oldList[oldItemPosition].timeStamp != newList[newItemPosition].timeStamp -> false
        oldList[oldItemPosition].title != newList[newItemPosition].title -> false
        else -> true
    }
}