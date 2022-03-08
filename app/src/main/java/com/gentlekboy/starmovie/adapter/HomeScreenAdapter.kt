package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.Movie
import com.gentlekboy.starmovie.databinding.NowShowingViewHolderBinding
import com.gentlekboy.starmovie.utils.HomeScreenInterface
import com.gentlekboy.starmovie.utils.MyDiffUtil

/**
 * Recycler view adapter for the Home Screen. Makes use of [MyDiffUtil] for updating data.
 */
class HomeScreenAdapter(
    private val homeScreenInterface: HomeScreenInterface
) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenViewHolder>() {

    //List holding movies currently being shown on the recycler view
    private var oldMovieList = ArrayList<Movie>()

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
            itemView.setOnClickListener { homeScreenInterface.navigateToMovieDetails(title) }
        }
    }

    //Notify the recycler view of the size of the items to be passed in the recycler view
    override fun getItemCount() = oldMovieList.size

    /**
     * Adds a new list of movies to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addMovies(newMovieList: ArrayList<Movie>) {
        val diffUtilLists = MyDiffUtil(oldMovieList, newMovieList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldMovieList = newMovieList
        diffResult.dispatchUpdatesTo(this)
    }
}