package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.TicketsModel
import com.gentlekboy.starmovie.databinding.TicketsViewHolderBinding
import com.gentlekboy.starmovie.utils.clickinterface.TicketsClickInterface
import com.gentlekboy.starmovie.utils.diffutil.TicketsDiffUtil

/**
 * Recycler view adapter for the Tickets Screen. Makes use of [TicketsDiffUtil] for updating data.
 */
class TicketsAdapter(
    private val ticketsClickInterface: TicketsClickInterface
) : RecyclerView.Adapter<TicketsAdapter.TicketsViewHolder>() {

    private var oldTicketsList = ArrayList<TicketsModel>()

    inner class TicketsViewHolder(val binding: TicketsViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TicketsViewHolder(
        TicketsViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) = with(holder) {
        with(oldTicketsList[position]) {
            binding.movieBanner.setImageResource(image)
            binding.movieNameTv.text = movieName
            binding.movieShowtimeTv.text = movieShowTime
            binding.movieShowtimeDate.text = movieShowDate
            binding.cinemaSeat.text = cinemaSeat

            itemView.setOnClickListener {
                ticketsClickInterface.navigateToTicketsDetails(
                    image,
                    movieName,
                    movieShowTime,
                    movieShowDate,
                    cinemaSeat
                )
            }
        }
    }

    override fun getItemCount() = oldTicketsList.size

    /**
     * Adds a new list of tickets to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addTickets(newTicketsList: ArrayList<TicketsModel>) {
        val diffUtilLists = TicketsDiffUtil(oldTicketsList, newTicketsList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldTicketsList = newTicketsList
        diffResult.dispatchUpdatesTo(this)
    }
}