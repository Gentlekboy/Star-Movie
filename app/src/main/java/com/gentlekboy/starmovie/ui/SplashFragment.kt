package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000L)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}