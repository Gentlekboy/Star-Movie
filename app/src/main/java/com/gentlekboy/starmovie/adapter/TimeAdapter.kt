package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.TimeModel
import com.gentlekboy.starmovie.databinding.TimeViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.TimeDiffUtil

/**
 * Recycler view adapter for the ShowTime Screen. Makes use of [TimeDiffUtil] for updating data.
 */
class TimeAdapter : RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    private var oldTimeList = ArrayList<TimeModel>()

    inner class TimeViewHolder(val binding: TimeViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TimeViewHolder(
        TimeViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) = with(holder) {
        with(oldTimeList[position]) {
            binding.timeTv.text = time
        }
    }

    override fun getItemCount() = oldTimeList.size

    /**
     * Adds a new list of videos to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addTimes(newTimeList: ArrayList<TimeModel>) {
        val diffUtilLists = TimeDiffUtil(oldTimeList, newTimeList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldTimeList = newTimeList
        diffResult.dispatchUpdatesTo(this)
    }
}