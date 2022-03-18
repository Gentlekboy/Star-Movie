package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.VideosAdapter
import com.gentlekboy.starmovie.data.videoList
import com.gentlekboy.starmovie.databinding.FragmentVideosBinding

class VideosFragment : Fragment() {
    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!
    private val videosAdapter by lazy { VideosAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.videosRecyclerView.adapter = videosAdapter
        videosAdapter.addCastAndCrew(videoList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}