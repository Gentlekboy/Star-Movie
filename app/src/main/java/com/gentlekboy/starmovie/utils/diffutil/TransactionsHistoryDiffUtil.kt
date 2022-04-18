package com.gentlekboy.starmovie.utils.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.gentlekboy.starmovie.data.model.TransactionHistoryModel

/**
 * DiffUtil class for the transactions history recycler view adapter
 */
class TransactionsHistoryDiffUtil(
    private val oldList: ArrayList<TransactionHistoryModel>,
    private val newList: ArrayList<TransactionHistoryModel>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = when {
        oldList[oldItemPosition].id != newList[newItemPosition].id -> false
        oldList[oldItemPosition].transactionTitle != newList[newItemPosition].transactionTitle -> false
        oldList[oldItemPosition].transactionDescription != newList[newItemPosition].transactionDescription -> false
        oldList[oldItemPosition].transactionAmount != newList[newItemPosition].transactionAmount -> false
        oldList[oldItemPosition].transactionDate != newList[newItemPosition].transactionDate -> false
        oldList[oldItemPosition].image != newList[newItemPosition].image -> false
        else -> true
    }
}