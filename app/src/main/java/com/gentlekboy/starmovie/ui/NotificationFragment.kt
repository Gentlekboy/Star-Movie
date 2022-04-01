package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.NotificationAdapter
import com.gentlekboy.starmovie.data.model.notificationList
import com.gentlekboy.starmovie.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    private val notificationAdapter: NotificationAdapter by lazy { NotificationAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.notificationRecyclerView.adapter = notificationAdapter
        notificationAdapter.addNotifications(notificationList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}