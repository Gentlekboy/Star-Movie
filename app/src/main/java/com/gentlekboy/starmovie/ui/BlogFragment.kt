package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gentlekboy.starmovie.R
import com.gentlekboy.starmovie.adapter.BlogAdapter
import com.gentlekboy.starmovie.data.model.blogList
import com.gentlekboy.starmovie.databinding.FragmentBlogBinding
import com.gentlekboy.starmovie.utils.clickinterface.BlogClickInterface

class BlogFragment : Fragment(), BlogClickInterface {
    private var _binding: FragmentBlogBinding? = null
    private val binding get() = _binding!!
    private val blogAdapter by lazy { BlogAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpClickEvents()
    }

    private fun setUpAdapter() {
        binding.blogRecyclerView.adapter = blogAdapter
        blogAdapter.addBlog(blogList)
    }

    private fun setUpClickEvents() {
        binding.apply {
            backArrow.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToItemDetails(movieTitle: String) {
        findNavController().navigate(R.id.action_blogFragment_to_blogDetailFragment)
    }
}