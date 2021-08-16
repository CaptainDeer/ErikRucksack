package com.captaindeer.erikrucksack.ui.billboard

import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse

interface BillboardInterface {

    interface Presenter {
        fun getTopAnime()
        fun getByName(name: String)
    }

    interface View {
        fun setUpdateDataBillboard(itemBillboardResponse: MutableList<ItemBillboardResponse>)
        fun onError(msg: String)
    }

}