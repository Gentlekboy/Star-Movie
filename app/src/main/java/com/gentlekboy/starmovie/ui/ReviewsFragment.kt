package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.ReviewsAdapter
import com.gentlekboy.starmovie.data.model.reviewsList
import com.gentlekboy.starmovie.databinding.FragmentReviewsBinding

class ReviewsFragment : Fragment() {
    private var _binding: FragmentReviewsBinding? = null
    private val binding get() = _binding!!
    private val reviewsAdapter: ReviewsAdapter by lazy { ReviewsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.reviewsRecyclerView.adapter = reviewsAdapter
        reviewsAdapter.addReviews(reviewsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}