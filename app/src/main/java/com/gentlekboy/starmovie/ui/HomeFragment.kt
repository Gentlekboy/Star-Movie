package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.adapter.HomeScreenAdapter
import com.gentlekboy.starmovie.data.comingSoonMovieList
import com.gentlekboy.starmovie.data.nowShowingMovieList
import com.gentlekboy.starmovie.databinding.FragmentHomeBinding
import com.gentlekboy.starmovie.utils.RecyclerviewClickInterface
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment(), RecyclerviewClickInterface {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeScreenAdapter by lazy { HomeScreenAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpClickEvents()
    }

    private fun setUpAdapter() {
        binding.homeRecyclerView.adapter = homeScreenAdapter
        homeScreenAdapter.addMovies(nowShowingMovieList)
    }

    private fun setUpClickEvents() {
        binding.comingSoonContainer.setOnClickListener {
            homeScreenAdapter.addMovies(comingSoonMovieList)

            binding.playIcon.visibility = View.INVISIBLE
            binding.comingSoonContainer.setBackgroundResource(R.drawable.dual_selected_background)
            binding.comingSoonTv.setTextColor(resources.getColor(R.color.white))
            binding.nowShowingContainer.setBackgroundResource(R.color.transparent)
            binding.nowShowingTv.setTextColor(resources.getColor(R.color.black))
        }

        binding.nowShowingContainer.setOnClickListener {
            homeScreenAdapter.addMovies(nowShowingMovieList)

            binding.playIcon.visibility = View.VISIBLE
            binding.comingSoonContainer.setBackgroundResource(R.color.transparent)
            binding.comingSoonTv.setTextColor(resources.getColor(R.color.black))
            binding.nowShowingContainer.setBackgroundResource(R.drawable.dual_selected_background)
            binding.nowShowingTv.setTextColor(resources.getColor(R.color.white))
        }

        binding.homeSearchIcon.setOnClickListener {
            Snackbar.make(binding.root, "Movie search is coming soon", Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToItemDetails(movieTitle: String) {
        Snackbar.make(binding.root, "$movieTitle details coming soon", Snackbar.LENGTH_LONG).show()
    }
}