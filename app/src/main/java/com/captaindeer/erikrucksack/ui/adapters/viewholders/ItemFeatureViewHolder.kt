package com.captaindeer.erikrucksack.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.databinding.ItemFeatureBinding

class ItemFeatureViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemFeatureBinding.bind(view)

    fun bind(name: String, function: String) {
        binding.itemFeatureName.text = name.toString()
        binding.itemFeatureFunction.text = function.toString()
    }

}