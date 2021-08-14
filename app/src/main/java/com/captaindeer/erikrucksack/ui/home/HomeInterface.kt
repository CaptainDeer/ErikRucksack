package com.captaindeer.erikrucksack.ui.home

import com.captaindeer.erikrucksack.data.remote.responses.models.ItemFeatureModel
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel

interface HomeInterface {
    interface Presenter {
        fun itemMiniTechData()
        fun itemTechData()
        fun itemFeature()
    }

    interface View {
        fun setUpdateDataMiniTech(itemsTech: ArrayList<ItemTechModel>)
        fun setUpdateDataItemFeature(itemFeature: ArrayList<ItemFeatureModel> )
    }
}