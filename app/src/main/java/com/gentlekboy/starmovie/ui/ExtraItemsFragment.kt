package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.ExtraItemAdapter
import com.gentlekboy.starmovie.data.model.extraItemList
import com.gentlekboy.starmovie.databinding.FragmentExtraItemsBinding

class ExtraItemsFragment : Fragment() {
    private var _binding: FragmentExtraItemsBinding? = null
    private val binding get() = _binding!!
    private val extraItemAdapter: ExtraItemAdapter by lazy { ExtraItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExtraItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.extraItemsRecyclerView.adapter = extraItemAdapter
        extraItemAdapter.addExtraItems(extraItemList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}