package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.CastAndCrew
import com.gentlekboy.starmovie.databinding.CastAndCrewViewHolderBinding
import com.gentlekboy.starmovie.utils.CastAndCrewDiffUtil

/**
 * Recycler view adapter for the Cast and Crew Screen. Makes use of [CastAndCrewDiffUtil] for updating data.
 */
class CastAndCrewAdapter : RecyclerView.Adapter<CastAndCrewAdapter.CastAndCrewViewHolder>() {

    private var oldCastAndCrewList = ArrayList<CastAndCrew>()

    inner class CastAndCrewViewHolder(val binding: CastAndCrewViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CastAndCrewViewHolder(
        CastAndCrewViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: CastAndCrewViewHolder, position: Int) = with(holder) {
        with(oldCastAndCrewList[position]) {
            binding.realNameTv.text = realName
            binding.movieNameTv.text = movieName
            binding.image.setImageResource(image)
        }
    }

    override fun getItemCount() = oldCastAndCrewList.size

    /**
     * Adds a new list of cast and crew to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addCastAndCrew(newCastAndCrewList: ArrayList<CastAndCrew>) {
        val diffUtilLists = CastAndCrewDiffUtil(oldCastAndCrewList, newCastAndCrewList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldCastAndCrewList = newCastAndCrewList
        diffResult.dispatchUpdatesTo(this)
    }
}