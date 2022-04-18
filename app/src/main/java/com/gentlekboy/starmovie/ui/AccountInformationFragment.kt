package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.databinding.FragmentAccountInformationBinding

class AccountInformationFragment : Fragment() {
    private var _binding: FragmentAccountInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpClickEvents()
    }

    private fun setUpClickEvents() {
        binding.apply {
            changePassword.setOnClickListener {
                findNavController().navigate(R.id.action_accountInformationFragment_to_changePasswordFragment)
            }

            saveChangesButton.setOnClickListener {
                findNavController().navigate(R.id.action_accountInformationFragment_to_profileFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}