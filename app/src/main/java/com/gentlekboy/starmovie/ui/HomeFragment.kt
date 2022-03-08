package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.adapter.HomeScreenAdapter
import com.gentlekboy.starmovie.data.movieList
import com.gentlekboy.starmovie.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeScreenAdapter by lazy { HomeScreenAdapter() }

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
        homeScreenAdapter.addMovies(movieList)
    }

    private fun setUpClickEvents() {
        binding.comingSoonContainer.setOnClickListener {
            movieList.shuffle()
            binding.comingSoonContainer.visibility = View.VISIBLE
            binding.comingSoonTv.setTextColor(resources.getColor(R.color.white))
            binding.nowShowingContainer.visibility = View.INVISIBLE
            binding.nowShowingTv.setTextColor(resources.getColor(R.color.black))
        }

        binding.nowShowingContainer.setOnClickListener {
            movieList.shuffle()
            binding.comingSoonContainer.visibility = View.INVISIBLE
            binding.comingSoonTv.setTextColor(resources.getColor(R.color.black))
            binding.nowShowingContainer.visibility = View.VISIBLE
            binding.nowShowingTv.setTextColor(resources.getColor(R.color.white))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}