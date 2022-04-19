package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.adapter.TicketsAdapter
import com.gentlekboy.starmovie.data.model.ticketsList
import com.gentlekboy.starmovie.databinding.FragmentTicketBinding
import com.gentlekboy.starmovie.utils.clickinterface.TicketsClickInterface

class TicketFragment : Fragment(), TicketsClickInterface {
    private var _binding: FragmentTicketBinding? = null
    private val binding get() = _binding!!
    private val ticketsAdapter by lazy { TicketsAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTicketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.ticketsRecyclerView.adapter = ticketsAdapter
        ticketsAdapter.addTickets(ticketsList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToTicketsDetails(
        movieTitle: Int,
        movieName: String,
        movieShowTime: String,
        movieShowDate: String,
        cinemaSeat: String
    ) {
        findNavController().navigate(R.id.action_ticketFragment_to_ticketDetailsFragment)
    }
}