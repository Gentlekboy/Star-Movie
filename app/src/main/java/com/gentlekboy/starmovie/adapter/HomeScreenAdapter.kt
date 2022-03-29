package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.MovieModel
import com.gentlekboy.starmovie.databinding.NowShowingViewHolderBinding
import com.gentlekboy.starmovie.utils.clickinterface.RecyclerviewClickInterface
import com.gentlekboy.starmovie.utils.diffutil.HomeDiffUtil

/**
 * Recycler view adapter for the Home Screen. Makes use of [HomeDiffUtil] for updating data.
 */
class HomeScreenAdapter(
    private val recyclerviewClickInterface: RecyclerviewClickInterface
) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    //List holding movies currently being shown on the recycler view
    private var oldMovieList = ArrayList<MovieModel>()

    //Create view holder class using view binding
    inner class HomeScreenViewHolder(val binding: NowShowingViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    //Inflate the view holder layout in the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HomeScreenViewHolder(
        NowShowingViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    //Bound data from the movie data class to views in the view holder
    override fun onBindViewHolder(holder: HomeScreenViewHolder, position: Int) = with(holder) {
        with(oldMovieList[position]) {
            binding.genreAndTime.text = genre
            binding.movieTitle.text = title
            binding.ratingBar.rating = rating
            binding.movieBanner.setImageResource(image)
            itemView.setOnClickListener { recyclerviewClickInterface.navigateToItemDetails(title) }
        }
    }

    //Notify the recycler view of the size of the items to be passed in the recycler view
    override fun getItemCount() = oldMovieList.size

    /**
     * Adds a new list of movies to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addMovies(newMovieList: ArrayList<MovieModel>) {
        val diffUtilLists = HomeDiffUtil(oldMovieList, newMovieList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldMovieList = newMovieList
        diffResult.dispatchUpdatesTo(this)
    }
}