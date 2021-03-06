package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.BlogModel
import com.gentlekboy.starmovie.databinding.DetailBlogViewHolderBinding
import com.gentlekboy.starmovie.utils.clickinterface.BlogClickInterface
import com.gentlekboy.starmovie.utils.diffutil.BlogDiffUtil

/**
 * Recycler view adapter for blogs on the detail screen. Makes use of [BlogDiffUtil] for updating data.
 */
class DetailBlogAdapter(
    private val blogClickInterface: BlogClickInterface
) : RecyclerView.Adapter<DetailBlogAdapter.DetailBlogViewHolder>() {

    private var oldBlogList = ArrayList<BlogModel>()

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
            itemView.setOnClickListener { blogClickInterface.navigateToItemDetails(title) }
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