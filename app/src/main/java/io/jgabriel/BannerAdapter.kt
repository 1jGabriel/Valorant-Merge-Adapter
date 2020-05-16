package io.jgabriel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.banner_item.view.*

class BannerAdapter :
    ListAdapter<Banner, BannerAdapter.BannerViewHolder>(BannerDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BannerViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_item, parent, false)
    )

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun swapData(data: List<Banner>) {
        submitList(data.toMutableList())
    }

    inner class BannerViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Banner) = with(itemView) {
            Glide.with(imageViewBanner.context)
                .load(item.banner)
                .into(itemView.imageViewBanner)
        }
    }

    private class BannerDC : DiffUtil.ItemCallback<Banner>() {
        override fun areItemsTheSame(
            oldItem: Banner,
            newItem: Banner
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Banner,
            newItem: Banner
        ): Boolean {
            return oldItem.banner == newItem.banner
        }
    }
}