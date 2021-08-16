package com.captaindeer.erikrucksack.ui.billboard

import android.util.Log
import com.captaindeer.erikrucksack.data.remote.RetrofitBuilder
import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BillboardPresenter(val view: BillboardInterface.View) : BillboardInterface.Presenter {

    private var retrofit = RetrofitBuilder()

    override fun getTopAnime() {
        CoroutineScope(Dispatchers.IO).launch {
            val billboard = retrofit.getTopAnime()
            if (billboard.isSuccessful) {
                var response = mutableListOf<ItemBillboardResponse>()
                response.addAll(billboard.body()!!.top)

                withContext(Dispatchers.Main) {
                    view.setUpdateDataBillboard(response)
                    Log.e("TAG", "enviando datos a la vista")
                }

            } else {
                withContext(Dispatchers.Main) {
                    view.onError(billboard.errorBody().toString())
                }
            }
        }
    }

    override fun getByName(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val billboard = retrofit.getByName(name)
            if (billboard.isSuccessful) {
                var response = mutableListOf<ItemBillboardResponse>()
                response.addAll(billboard.body()!!.results)

                withContext(Dispatchers.Main) {
                    view.setUpdateDataBillboard(response)
                }
            } else {
                withContext(Dispatchers.Main) {
                    view.onError(billboard.errorBody().toString())
                }
            }
        }
    }
}