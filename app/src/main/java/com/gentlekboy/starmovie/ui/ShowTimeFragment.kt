package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.DateAdapter
import com.gentlekboy.starmovie.adapter.TimeAdapter
import com.gentlekboy.starmovie.data.model.dateList
import com.gentlekboy.starmovie.data.model.timeList
import com.gentlekboy.starmovie.databinding.FragmentShowTimeBinding

class ShowTimeFragment : Fragment() {
    private var _binding: FragmentShowTimeBinding? = null
    private val binding get() = _binding!!
    private val timeAdapter: TimeAdapter by lazy { TimeAdapter() }
    private val dateAdapter: DateAdapter by lazy { DateAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowTimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapters()
    }

    private fun setUpAdapters() {
        binding.apply {
            iMaxRecyclerView.adapter = timeAdapter
            twoDRecyclerView.adapter = timeAdapter
            dateRecyclerView.adapter = dateAdapter
        }

        timeAdapter.addTimes(timeList)
        dateAdapter.addDates(dateList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}