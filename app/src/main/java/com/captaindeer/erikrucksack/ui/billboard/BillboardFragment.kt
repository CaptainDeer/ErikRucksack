package com.captaindeer.erikrucksack.ui.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse
import com.captaindeer.erikrucksack.databinding.FragmentBillboardBinding
import com.captaindeer.erikrucksack.ui.adapters.BillboardAdapter
import com.captaindeer.erikrucksack.ui.adapters.listeners.ItemBillboardListener
import com.captaindeer.erikrucksack.ui.itembillboard.ItemBillboardDialog

class BillboardFragment : Fragment(), BillboardInterface.View, ItemBillboardListener,
    SearchView.OnQueryTextListener {

    private var _binding: FragmentBillboardBinding? = null
    private val binding get() = _binding
    private var presenter: BillboardPresenter? = null
    private var adapter: BillboardAdapter? = null
    private var itemBillboardResponse = mutableListOf<ItemBillboardResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = BillboardPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBillboardBinding.inflate(inflater, container, false)
        binding!!.billboardSearchview.setOnQueryTextListener(this)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Adapter
        adapter = BillboardAdapter(itemBillboardResponse, this)

        //RecyclerView
        binding!!.billboardRv.setHasFixedSize(true)
        binding!!.billboardRv.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        binding!!.billboardRv.adapter = adapter

        //Functions
        presenter!!.getTopAnime()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setUpdateDataBillboard(itemBillboardResponse: MutableList<ItemBillboardResponse>) {
        adapter!!.updateData(itemBillboardResponse)
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
    }

    override fun showDialogBillboard(itemBillboardResponse: ItemBillboardResponse) {
        ItemBillboardDialog(itemBillboardResponse).show(requireFragmentManager(), "customDialog")
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            presenter!!.getByName(query.toString().toLowerCase())
        } else {
            presenter!!.getTopAnime()
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}