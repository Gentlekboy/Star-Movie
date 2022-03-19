package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.Blog
import com.gentlekboy.starmovie.databinding.DetailBlogViewHolderBinding
import com.gentlekboy.starmovie.utils.BlogDiffUtil
import com.gentlekboy.starmovie.utils.RecyclerviewClickInterface

/**
 * Recycler view adapter for blogs on the detail screen. Makes use of [BlogDiffUtil] for updating data.
 */
class DetailBlogAdapter(
    private val recyclerviewClickInterface: RecyclerviewClickInterface
) : RecyclerView.Adapter<DetailBlogAdapter.DetailBlogViewHolder>() {

    private var oldBlogList = ArrayList<Blog>()

    inner class DetailBlogViewHolder(val binding: DetailBlogViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailBlogViewHolder(
        DetailBlogViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DetailBlogViewHolder, position: Int) = with(holder) {
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
    fun addBlog(newBlogList: ArrayList<Blog>) {
        val diffUtilLists = BlogDiffUtil(oldBlogList, newBlogList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldBlogList = newBlogList
        diffResult.dispatchUpdatesTo(this)
    }
}