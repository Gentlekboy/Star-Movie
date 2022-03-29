package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.ReviewsModel
import com.gentlekboy.starmovie.databinding.ReviewsViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.ReviewsDiffUtil

/**
 * Recycler view adapter for the Reviews Screen. Makes use of [ReviewsDiffUtil] for updating data.
 */
class ReviewsAdapter : RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>() {

    private var oldReviewsList = ArrayList<ReviewsModel>()

    inner class ReviewsViewHolder(val binding: ReviewsViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ReviewsViewHolder(
        ReviewsViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) = with(holder) {
        with(oldReviewsList[position]) {
            binding.profileImage.setImageResource(image)
            binding.fullNameTv.text = name
            binding.dateTv.text = date
            binding.movieRatingBar.rating = rating
            binding.reviewTv.text = review
        }
    }

    override fun getItemCount() = oldReviewsList.size

    /**
     * Adds a new list of reviews to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addReviews(newReviewsList: ArrayList<ReviewsModel>) {
        val diffUtilLists = ReviewsDiffUtil(oldReviewsList, newReviewsList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldReviewsList = newReviewsList
        diffResult.dispatchUpdatesTo(this)
    }
}