package com.captaindeer.erikrucksack.ui.itemtech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel
import com.captaindeer.erikrucksack.databinding.FragmentItemTechDialogBinding
import com.squareup.picasso.Picasso

class ItemTechDialog(private val itemTechModel: ItemTechModel) : DialogFragment() {
    private var _binding: FragmentItemTechDialogBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemTechDialogBinding.inflate(inflater, container, false)

        Picasso.get().load(itemTechModel.image).into(binding!!.itemTechIv)
        binding!!.itemTechTvName.text = itemTechModel.name.toString()
        binding!!.itemTechTvFunction.text = itemTechModel.function.toString()


        binding!!.btnItemTechDialog.setOnClickListener {
            dismiss()
        }

        return binding?.root
    }

}