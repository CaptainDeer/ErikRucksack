package com.captaindeer.erikrucksack.ui.itembillboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse
import com.captaindeer.erikrucksack.databinding.FragmentItemBillboardDialogBinding
import com.squareup.picasso.Picasso

class ItemBillboardDialog(private val itemBillboardResponse: ItemBillboardResponse) :
    DialogFragment() {

    private var _binding: FragmentItemBillboardDialogBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBillboardDialogBinding.inflate(inflater, container, false)

        binding!!.itemBillboardDialogTvTitle.text = itemBillboardResponse.title
        binding!!.itemBillboardDialogTvEpisodes.text = itemBillboardResponse.episodes.toString()
        binding!!.itemBillboardDialogTvScore.text = itemBillboardResponse.score.toString()
        Picasso.get().load(itemBillboardResponse.image_url).into(binding!!.itemBillboardDialogIv)

        binding!!.itemBillboardDialogBtn.setOnClickListener {
            dismiss()
        }
        binding!!.itemBillboardDialogTvUrl.setOnClickListener {
            val uri: Uri = Uri.parse(itemBillboardResponse.url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        return binding?.root
    }

}