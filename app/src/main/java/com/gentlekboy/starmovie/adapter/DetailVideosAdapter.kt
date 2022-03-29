package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.VideosModel
import com.gentlekboy.starmovie.databinding.DetailVideosViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.VideosDiffUtil

/**
 * Recycler view adapter for videos on the detail screen. Makes use of [VideosDiffUtil] for updating data.
 */
class DetailVideosAdapter : RecyclerView.Adapter<DetailVideosAdapter.DetailVideosViewHolder>() {

    private var oldVideosList = ArrayList<VideosModel>()

    inner class DetailVideosViewHolder(val binding: DetailVideosViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailVideosViewHolder(
        DetailVideosViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DetailVideosViewHolder, position: Int) = with(holder) {
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