package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.TransactionHistoryModel
import com.gentlekboy.starmovie.databinding.TransactionHistoryViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.TransactionsHistoryDiffUtil

/**
 * Recycler view adapter for the Transaction History Screen. Makes use of [TransactionsHistoryDiffUtil] for updating data.
 */
class TransactionsHistoryAdapter :
    RecyclerView.Adapter<TransactionsHistoryAdapter.TransactionsHistoryViewHolder>() {

    private var oldTransactionHistoryList = ArrayList<TransactionHistoryModel>()

    inner class TransactionsHistoryViewHolder(val binding: TransactionHistoryViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TransactionsHistoryViewHolder(
            TransactionHistoryViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TransactionsHistoryViewHolder, position: Int) =
        with(holder) {
            with(oldTransactionHistoryList[position]) {
                binding.transactionHistoryIcon.setImageResource(image)
                binding.transactionTitleTv.text = transactionTitle
                binding.transactionDescriptionTv.text = transactionDescription
                binding.transactionDateTv.text = transactionDate
                binding.transactionAmountTv.text = transactionAmount
            }
        }

    override fun getItemCount() = oldTransactionHistoryList.size

    /**
     * Adds a new list of transaction history to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addTransactionHistory(newTransactionHistoryList: ArrayList<TransactionHistoryModel>) {
        val diffUtilLists =
            TransactionsHistoryDiffUtil(oldTransactionHistoryList, newTransactionHistoryList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldTransactionHistoryList = newTransactionHistoryList
        diffResult.dispatchUpdatesTo(this)
    }
}