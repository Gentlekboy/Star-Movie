package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.PhotosAdapter
import com.gentlekboy.starmovie.data.photosList
import com.gentlekboy.starmovie.databinding.FragmentPhotosBinding

class PhotosFragment : Fragment() {
    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!
    private val photosAdapter by lazy { PhotosAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.photosRecyclerView.adapter = photosAdapter
        photosAdapter.addCastAndCrew(photosList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}