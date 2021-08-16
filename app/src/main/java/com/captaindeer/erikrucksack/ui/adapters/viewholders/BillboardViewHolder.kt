package com.captaindeer.erikrucksack.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.erikrucksack.databinding.ItemBillboardBinding
import com.squareup.picasso.Picasso

class BillboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemBillboardBinding.bind(view)

    fun bind(title: String, score: Float, image: String) {
        Picasso.get().load(image).into(binding.itemBillboardIvIv)
        binding.itemBillboardTvTitle.text = title
        binding.itemBillboardTvScore.text = score.toString()
    }

}