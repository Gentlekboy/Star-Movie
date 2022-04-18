package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.adapter.CastAndCrewAdapter
import com.gentlekboy.starmovie.data.model.castAndCrewList
import com.gentlekboy.starmovie.databinding.FragmentCastAndCrewBinding

class CastAndCrewFragment : Fragment() {
    private var _binding: FragmentCastAndCrewBinding? = null
    private val binding get() = _binding!!
    private val castAndCrewAdapter by lazy { CastAndCrewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCastAndCrewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpClickEvents()
    }

    private fun setUpClickEvents() {
        binding.apply {
            backArrow.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun setUpAdapter() {
        binding.castAndCrewRecyclerView.adapter = castAndCrewAdapter
        castAndCrewAdapter.addCastAndCrew(castAndCrewList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}