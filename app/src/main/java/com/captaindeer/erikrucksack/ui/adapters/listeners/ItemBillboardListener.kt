package com.captaindeer.erikrucksack.ui.adapters.listeners

import com.captaindeer.erikrucksack.data.remote.responses.ItemBillboardResponse

interface ItemBillboardListener {

    fun showDialogBillboard(itemBillboardResponse: ItemBillboardResponse)
}