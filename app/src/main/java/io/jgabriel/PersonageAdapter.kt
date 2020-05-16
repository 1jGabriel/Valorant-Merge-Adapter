package io.jgabriel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.personagem_item.view.*

class PersonageAdapter :
    ListAdapter<Personage, PersonageAdapter.PersonageViewHolder>(PersonageDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PersonageViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.personagem_item, parent, false)
    )

    override fun onBindViewHolder(holder: PersonageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun swapData(data: List<Personage>) {
        submitList(data.toMutableList())
    }

    inner class PersonageViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Personage) = with(itemView) {
            textViewUserName.text = item.name
            textViewUserDescription.text = item.description
            Glide.with(itemView.imageViewAvatar.context)
                .load(item.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

    private class PersonageDC : DiffUtil.ItemCallback<Personage>() {
        override fun areItemsTheSame(
            oldItem: Personage,
            newItem: Personage
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Personage,
            newItem: Personage
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}