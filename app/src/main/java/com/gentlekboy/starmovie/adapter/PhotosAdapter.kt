package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.Photos
import com.gentlekboy.starmovie.databinding.PhotosViewHolderBinding
import com.gentlekboy.starmovie.utils.PhotosDiffUtil

/**
 * Recycler view adapter for the Photos Screen. Makes use of [PhotosDiffUtil] for updating data.
 */
class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    private var oldPhotosList = ArrayList<Photos>()

    inner class PhotosViewHolder(val binding: PhotosViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotosViewHolder(
        PhotosViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) = with(holder) {
        with(oldPhotosList[position]) {
            binding.moviePhoto.setImageResource(image)
        }
    }

    override fun getItemCount() = oldPhotosList.size

    /**
     * Adds a new list of photos to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addCastAndCrew(newPhotosList: ArrayList<Photos>) {
        val diffUtilLists = PhotosDiffUtil(oldPhotosList, newPhotosList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldPhotosList = newPhotosList
        diffResult.dispatchUpdatesTo(this)
    }
}