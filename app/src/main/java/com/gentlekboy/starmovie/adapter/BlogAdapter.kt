package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.BlogModel
import com.gentlekboy.starmovie.databinding.BlogViewHolderBinding
import com.gentlekboy.starmovie.utils.clickinterface.RecyclerviewClickInterface
import com.gentlekboy.starmovie.utils.diffutil.BlogDiffUtil

/**
 * Recycler view adapter for the Blog Screen. Makes use of [BlogDiffUtil] for updating data.
 */
class BlogAdapter(
    private val recyclerviewClickInterface: RecyclerviewClickInterface
) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    private var oldBlogList = ArrayList<BlogModel>()

    inner class BlogViewHolder(val binding: BlogViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BlogViewHolder(
        BlogViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) = with(holder) {
        with(oldBlogList[position]) {
            binding.durationTv.text = timeStamp
            binding.blogTitleTv.text = title
            binding.blogImage.setImageResource(image)
            itemView.setOnClickListener { recyclerviewClickInterface.navigateToItemDetails(title) }
        }
    }

    override fun getItemCount() = oldBlogList.size

    /**
     * Adds a new list of blogs to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addBlog(newBlogList: ArrayList<BlogModel>) {
        val diffUtilLists = BlogDiffUtil(oldBlogList, newBlogList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldBlogList = newBlogList
        diffResult.dispatchUpdatesTo(this)
    }
}