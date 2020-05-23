package io.jgabriel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_info.view.*

class HeaderAdapter :
    ListAdapter<Header, HeaderAdapter.HeaderViewHolder>(HeaderDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeaderViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.header_info, parent, false)
    )

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) = holder.bind(getItem(position))

    fun swapData(data: List<Header>) {
        submitList(data.toMutableList())
    }

    inner class HeaderViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Header) = with(itemView) {
            textViewUser.text = item.title
            textViewAboutMe.text = item.subtitle
        }
    }

    private class HeaderDC : DiffUtil.ItemCallback<Header>() {
        override fun areItemsTheSame(
            oldItem: Header,
            newItem: Header
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Header,
            newItem: Header
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
