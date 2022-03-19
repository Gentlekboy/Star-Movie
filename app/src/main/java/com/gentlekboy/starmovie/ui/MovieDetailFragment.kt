package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.MovieViewPagerAdapter
import com.gentlekboy.starmovie.databinding.FragmentMovieDetailBinding
import com.google.android.material.tabs.TabLayout

class MovieDetailFragment : Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var detailMovieViewPager: MovieViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
        setUpTabLayout()
    }

    private fun setUpViewPager() {
        detailMovieViewPager = MovieViewPagerAdapter(requireActivity().supportFragmentManager)

        detailMovieViewPager.apply {
            addFragment(DetailFragment(), "Detail")
            addFragment(ReviewsFragment(), "Reviews")
            addFragment(ShowTimeFragment(), "Showtime")
        }
    }

    private fun setUpTabLayout() {
        binding.apply {
            viewPager.adapter = detailMovieViewPager
            tabLayout.setupWithViewPager(binding.viewPager)
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {}
                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}