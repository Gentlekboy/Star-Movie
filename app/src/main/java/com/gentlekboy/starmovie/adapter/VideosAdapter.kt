package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.VideosModel
import com.gentlekboy.starmovie.databinding.VideosViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.VideosDiffUtil

/**
 * Recycler view adapter for the Videos Screen. Makes use of [VideosDiffUtil] for updating data.
 */
class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    private var oldVideosList = ArrayList<VideosModel>()

    inner class VideosViewHolder(val binding: VideosViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VideosViewHolder(
        VideosViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) = with(holder) {
        with(oldVideosList[position]) {
            binding.video.setImageResource(image)
            binding.videoDuration.text = duration
        }
    }

    override fun getItemCount() = oldVideosList.size

    /**
     * Adds a new list of videos to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addVideos(newVideosList: ArrayList<VideosModel>) {
        val diffUtilLists = VideosDiffUtil(oldVideosList, newVideosList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldVideosList = newVideosList
        diffResult.dispatchUpdatesTo(this)
    }
}