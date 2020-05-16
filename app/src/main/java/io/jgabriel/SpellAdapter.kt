package io.jgabriel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.spell_item.view.*

class SpellAdapter :
    ListAdapter<Spell, SpellAdapter.SpellViewHolder>(MagiaDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SpellViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.spell_item, parent, false)
    )

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun swapData(data: List<Spell>) {
        submitList(data.toMutableList())
    }

    inner class SpellViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Spell) = with(itemView) {
            spellTitle.text = item.name
            spellDescription.text = item.description
        }
    }

    private class MagiaDC : DiffUtil.ItemCallback<Spell>() {
        override fun areItemsTheSame(
            oldItem: Spell,
            newItem: Spell
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Spell,
            newItem: Spell
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }
}