package com.captaindeer.erikrucksack.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemFeatureModel
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel
import com.captaindeer.erikrucksack.databinding.FragmentHomeBinding
import com.captaindeer.erikrucksack.ui.adapters.ItemFeatureAdapter
import com.captaindeer.erikrucksack.ui.adapters.ItemMiniTechAdapter
import com.captaindeer.erikrucksack.ui.adapters.listeners.ItemTechListener
import com.captaindeer.erikrucksack.ui.itemtech.ItemTechDialog


class HomeFragment : Fragment(), HomeInterface.View, ItemTechListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var presenter: HomePresenter
    private var adapterMiniTech: ItemMiniTechAdapter? = null
    private var adapterItemFeature: ItemFeatureAdapter? = null
    private var itemFeatureModel = arrayListOf<ItemFeatureModel>()
    private var itemsTechModel = arrayListOf<ItemTechModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = HomePresenter(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Adapters
        adapterMiniTech = ItemMiniTechAdapter(itemsTechModel, this)
        adapterItemFeature = ItemFeatureAdapter(itemFeatureModel)

        //Recyclerviews
        binding!!.homeRvTech.setHasFixedSize(true)
        binding!!.homeRvFeatures.setHasFixedSize(true)
        binding!!.homeRvTech.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
        binding!!.homeRvFeatures.layoutManager = LinearLayoutManager(requireContext())
        binding!!.homeRvTech.adapter = adapterMiniTech
        binding!!.homeRvFeatures.adapter = adapterItemFeature

        presenter.itemMiniTechData()
        presenter.itemFeature()

        //Clicks
        binding!!.btnGit.setOnClickListener {
            val uri: Uri = Uri.parse("https://github.com/CaptainDeer?tab=repositories")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setUpdateDataMiniTech(itemsTech: ArrayList<ItemTechModel>) {
        adapterMiniTech!!.updateData(itemsTech)
    }

    override fun setUpdateDataItemFeature(itemsFeature: ArrayList<ItemFeatureModel>) {
        adapterItemFeature!!.updateData(itemsFeature)
    }

    override fun showDialogTechItem(itemTechModel: ItemTechModel) {
        ItemTechDialog(itemTechModel).show(requireFragmentManager(), "customDialog")
    }


}