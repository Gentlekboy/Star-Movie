package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addFragmentToHost(DetailFragment())
        setUpClickEvents()
    }

    private fun setUpClickEvents() {
        binding.detailsContainer.setOnClickListener {
            changeBackgroundOfSelectedTab(
                binding.detailsContainer,
                binding.detailTv,
                binding.reviewsContainer,
                binding.reviewsTv,
                binding.showtimeContainer,
                binding.showtimeTv
            )
            addFragmentToHost(DetailFragment())
        }

        binding.reviewsContainer.setOnClickListener {
            changeBackgroundOfSelectedTab(
                binding.reviewsContainer,
                binding.reviewsTv,
                binding.detailsContainer,
                binding.detailTv,
                binding.showtimeContainer,
                binding.showtimeTv
            )
            addFragmentToHost(ReviewsFragment())
        }

        binding.showtimeContainer.setOnClickListener {
            changeBackgroundOfSelectedTab(
                binding.showtimeContainer,
                binding.showtimeTv,
                binding.detailsContainer,
                binding.detailTv,
                binding.reviewsContainer,
                binding.reviewsTv
            )
            addFragmentToHost(ShowTimeFragment())
        }
    }

    private fun changeBackgroundOfSelectedTab(
        selectedView: View,
        selectedTextView: TextView,
        firstUnselectedView: View,
        firstUnselectedTextView: TextView,
        secondUnselectedView: View,
        secondUnselectedTextView: TextView
    ) {
        selectedView.setBackgroundResource(R.drawable.dual_selected_background)
        selectedTextView.setTextColor(resources.getColor(R.color.red_button_text_color))

        firstUnselectedView.setBackgroundResource(R.color.transparent)
        firstUnselectedTextView.setTextColor(resources.getColor(R.color.black))

        secondUnselectedView.setBackgroundResource(R.color.transparent)
        secondUnselectedTextView.setTextColor(resources.getColor(R.color.black))
    }

    private fun addFragmentToHost(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.movie_detail_host, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}