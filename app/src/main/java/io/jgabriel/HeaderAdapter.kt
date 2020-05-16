package io.jgabriel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_info.view.*

class HeaderAdapter(private val header: Header) :
    RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeaderViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.header_info, parent, false)
    )

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) = holder.bind(header)

    inner class HeaderViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Header) = with(itemView) {
            textViewUser.text = item.title
            textViewAboutMe.text = item.subtitle
        }
    }

    override fun getItemCount() = 1
}