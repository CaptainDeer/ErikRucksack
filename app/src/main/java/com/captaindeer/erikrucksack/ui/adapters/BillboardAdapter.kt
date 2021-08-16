package com.captaindeer.erikrucksack.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.R
import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse
import com.captaindeer.erikrucksack.ui.adapters.listeners.ItemBillboardListener
import com.captaindeer.erikrucksack.ui.adapters.viewholders.BillboardViewHolder

class BillboardAdapter(
    private var itemBillboardResponse: MutableList<ItemBillboardResponse>,
    private val listener: ItemBillboardListener
) :
    RecyclerView.Adapter<BillboardViewHolder>() {

    fun updateData(itemBillboardResponse: MutableList<ItemBillboardResponse>) {
        this.itemBillboardResponse = itemBillboardResponse
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return BillboardViewHolder(
            layoutInflater.inflate(R.layout.item_billboard, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BillboardViewHolder, position: Int) {
        val itemBillboard = itemBillboardResponse[position]
        holder.bind(itemBillboard.title, itemBillboard.score, itemBillboard.image_url)

        holder.itemView.setOnClickListener {
            listener.showDialogBillboard(itemBillboard)
        }
    }

    override fun getItemCount(): Int = itemBillboardResponse.size
}