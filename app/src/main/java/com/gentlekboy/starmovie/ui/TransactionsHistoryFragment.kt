package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.TransactionsHistoryAdapter
import com.gentlekboy.starmovie.data.model.transactionHistoryList
import com.gentlekboy.starmovie.databinding.FragmentTransactionsHistoryBinding

class TransactionsHistoryFragment : Fragment() {
    private var _binding: FragmentTransactionsHistoryBinding? = null
    private val binding get() = _binding!!
    private val transactionsHistoryAdapter by lazy { TransactionsHistoryAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
    }

    private fun setUpAdapter() {
        binding.transactionHistoryRv.adapter = transactionsHistoryAdapter
        transactionsHistoryAdapter.addTransactionHistory(transactionHistoryList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}