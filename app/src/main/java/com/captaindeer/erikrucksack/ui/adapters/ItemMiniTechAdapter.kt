package com.captaindeer.erikrucksack.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.R
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel
import com.captaindeer.erikrucksack.ui.adapters.listeners.ItemTechListener
import com.captaindeer.erikrucksack.ui.adapters.viewholders.ItemMiniTechViewHolder

class ItemMiniTechAdapter(
    private var itemsMiniTech: ArrayList<ItemTechModel>,
    private val listener: ItemTechListener
) :
    RecyclerView.Adapter<ItemMiniTechViewHolder>() {

    fun updateData(itemsTechModel: ArrayList<ItemTechModel>) {
        this.itemsMiniTech = itemsTechModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemMiniTechViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ItemMiniTechViewHolder(
            layoutInflater.inflate(
                R.layout.item_mini_tech,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ItemMiniTechViewHolder,
        position: Int
    ) {
        with(holder) {
            with(itemsMiniTech[position]) {
                bind(this.image, this.name)
                holder.itemView.setOnClickListener {
                    listener.showDialogTechItem(ItemTechModel(this.image, this.name, this.function))
                }
            }
        }
    }

    override fun getItemCount(): Int = itemsMiniTech.size

}