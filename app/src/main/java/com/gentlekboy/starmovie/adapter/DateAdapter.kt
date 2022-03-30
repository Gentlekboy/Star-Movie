package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.DateModel
import com.gentlekboy.starmovie.databinding.DateViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.DateDiffUtil

/**
 * Recycler view adapter for the ShowTime Screen. Makes use of [DateDiffUtil] for updating data.
 */
class DateAdapter : RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    private var oldDateList = ArrayList<DateModel>()

    inner class DateViewHolder(val binding: DateViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DateViewHolder(
        DateViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) = with(holder) {
        with(oldDateList[position]) {
            binding.dateTv.text = date
            binding.dayTv.text = day
        }
    }

    override fun getItemCount() = oldDateList.size

    /**
     * Adds a new list of dates to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addDates(newDateList: ArrayList<DateModel>) {
        val diffUtilLists = DateDiffUtil(oldDateList, newDateList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldDateList = newDateList
        diffResult.dispatchUpdatesTo(this)
    }
}