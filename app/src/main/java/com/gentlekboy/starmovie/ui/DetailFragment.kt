package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.adapter.CastAndCrewAdapter
import com.gentlekboy.starmovie.adapter.DetailBlogAdapter
import com.gentlekboy.starmovie.adapter.DetailPhotosAdapter
import com.gentlekboy.starmovie.adapter.DetailVideosAdapter
import com.gentlekboy.starmovie.data.model.*
import com.gentlekboy.starmovie.databinding.FragmentDetailBinding
import com.gentlekboy.starmovie.utils.clickinterface.RecyclerviewClickInterface

class DetailFragment : Fragment(), RecyclerviewClickInterface {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val detailPhotosAdapter by lazy { DetailPhotosAdapter() }
    private val detailVideosAdapter by lazy { DetailVideosAdapter() }
    private val castAndCrewAdapter by lazy { CastAndCrewAdapter() }
    private val detailBlogAdapter by lazy { DetailBlogAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpCastAndCrewAdapter()
        setUpDetailPhotosAdapter()
        setUpDetailVideosAdapter()
        setUpDetailBlogAdapter()
        setUpClickEvents()
    }

    private fun setUpClickEvents() {
        binding.castAndCrewViewAll.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_castAndCrewFragment)
        }
        binding.photosViewAll.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_photosFragment)
        }
        binding.videosViewAll.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_videosFragment)
        }
        binding.blogViewAll.setOnClickListener {
            findNavController().navigate(R.id.action_blogDetailFragment_to_blogFragment)
        }
    }

    private fun setUpDetailBlogAdapter() {
        binding.detailBlogRv.adapter = detailBlogAdapter
        detailBlogAdapter.addBlog(blogList)
    }

    private fun setUpCastAndCrewAdapter() {
        val newCastAndCrewList = arrayListOf<CastAndCrewModel>()

        for (i in 0 until 4) {
            newCastAndCrewList.add(castAndCrewList[i])
        }

        binding.detailCastAndCrewRv.adapter = castAndCrewAdapter
        castAndCrewAdapter.addCastAndCrew(newCastAndCrewList)
    }

    private fun setUpDetailVideosAdapter() {
        binding.detailVideosRv.adapter = detailVideosAdapter
        detailVideosAdapter.addVideos(videoList)
    }

    private fun setUpDetailPhotosAdapter() {
        binding.detailPhotosRv.adapter = detailPhotosAdapter
        detailPhotosAdapter.addPhotos(photosList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToItemDetails(movieTitle: String) {
        findNavController().navigate(R.id.action_detailFragment_to_blogDetailFragment)
    }
}