package com.captaindeer.erikrucksack.ui.adapters.listeners

import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel

interface ItemTechListener {
    fun showDialogTechItem(itemTechModel: ItemTechModel)
}