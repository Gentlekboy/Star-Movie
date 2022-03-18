package com.gentlekboy.starmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gentlekboy.starmovie.adapter.BlogAdapter
import com.gentlekboy.starmovie.data.blogList
import com.gentlekboy.starmovie.databinding.FragmentBlogBinding
import com.gentlekboy.starmovie.utils.RecyclerviewClickInterface

class BlogFragment : Fragment(), RecyclerviewClickInterface {
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
    }

    private fun setUpAdapter() {
        binding.blogRecyclerView.adapter = blogAdapter
        blogAdapter.addBlog(blogList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun navigateToItemDetails(movieTitle: String) {

    }
}