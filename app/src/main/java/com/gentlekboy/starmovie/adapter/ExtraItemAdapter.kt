package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.ExtraItemModel
import com.gentlekboy.starmovie.databinding.ExtraItemViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.ExtraItemDiffUtil

/**
 * Recycler view adapter for the Extra Item Screen. Makes use of [ExtraItemDiffUtil] for updating data.
 */
class ExtraItemAdapter() : RecyclerView.Adapter<ExtraItemAdapter.ExtraItemViewHolder>() {

    private var oldExtraItemList = ArrayList<ExtraItemModel>()

    inner class ExtraItemViewHolder(val binding: ExtraItemViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExtraItemViewHolder(
        ExtraItemViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ExtraItemViewHolder, position: Int) = with(holder) {
        with(oldExtraItemList[position]) {
            binding.extraItemName.text = name
            binding.extraItemPrice.text = price
            binding.extraItemImage.setImageResource(image)
        }
    }

    override fun getItemCount() = oldExtraItemList.size

    /**
     * Adds a new list of extra items to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addExtraItems(newExtraItemList: ArrayList<ExtraItemModel>) {
        val diffUtilLists = ExtraItemDiffUtil(oldExtraItemList, newExtraItemList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldExtraItemList = newExtraItemList
        diffResult.dispatchUpdatesTo(this)
    }
}