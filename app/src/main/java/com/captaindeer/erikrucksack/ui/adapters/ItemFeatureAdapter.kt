package com.captaindeer.erikrucksack.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.R
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemFeatureModel
import com.captaindeer.erikrucksack.ui.adapters.viewholders.ItemFeatureViewHolder

class ItemFeatureAdapter(private var itemFeatures: ArrayList<ItemFeatureModel>) :
    RecyclerView.Adapter<ItemFeatureViewHolder>() {

    fun updateData(itemFeatureModel: ArrayList<ItemFeatureModel>) {
        this.itemFeatures = itemFeatureModel
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFeatureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ItemFeatureViewHolder(
            layoutInflater.inflate(R.layout.item_feature, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemFeatureViewHolder, position: Int) {

        val itemFeature = itemFeatures[position]
        holder.bind(itemFeature.name, itemFeature.description)

    }

    override fun getItemCount(): Int = itemFeatures.size
}