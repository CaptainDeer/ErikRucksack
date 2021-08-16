package com.captaindeer.erikrucksack.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.databinding.ItemMiniTechBinding
import com.squareup.picasso.Picasso

class ItemMiniTechViewHolder(view: View) :
    RecyclerView.ViewHolder(view) {

    private val binding = ItemMiniTechBinding.bind(view)

    fun bind(image: String, name: String) {
        binding.itemMiniTechTv.text = name
        Picasso.get().load(image).into(binding.itemMiniTechIv)
    }
}