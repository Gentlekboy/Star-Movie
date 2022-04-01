package com.gentlekboy.starmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gentlekboy.starmovie.data.model.NotificationModel
import com.gentlekboy.starmovie.databinding.NotificationViewHolderBinding
import com.gentlekboy.starmovie.utils.diffutil.NotificationDiffUtil

/**
 * Recycler view adapter for the Notifications Screen. Makes use of [NotificationDiffUtil] for updating data.
 */
class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    private var oldNotificationsList = ArrayList<NotificationModel>()

    inner class NotificationViewHolder(val binding: NotificationViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NotificationViewHolder(
        NotificationViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) = with(holder) {
        with(oldNotificationsList[position]) {
            binding.notificationTypeIcon.setImageResource(image)
            binding.notificationTypeIcon.setBackgroundResource(imageBackground)
            binding.notificationText.text = notification
            binding.notificationTime.text = time
        }
    }

    override fun getItemCount() = oldNotificationsList.size

    /**
     * Adds a new list of notifications to the adapter using the [DiffUtil] algorithm for optimization
     */
    fun addNotifications(newNotificationsList: ArrayList<NotificationModel>) {
        val diffUtilLists = NotificationDiffUtil(oldNotificationsList, newNotificationsList)
        val diffResult = DiffUtil.calculateDiff(diffUtilLists)
        oldNotificationsList = newNotificationsList
        diffResult.dispatchUpdatesTo(this)
    }
}