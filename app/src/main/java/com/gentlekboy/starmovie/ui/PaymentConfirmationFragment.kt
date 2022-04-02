package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.databinding.FragmentPaymentConfirmationBinding

class PaymentConfirmationFragment : Fragment() {
    private var _binding: FragmentPaymentConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickEvents()
    }

    private fun clickEvents() {
        binding.apply {
            viewTicketButton.setOnClickListener {
                findNavController().navigate(R.id.action_paymentConfirmationFragment_to_ticketFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}