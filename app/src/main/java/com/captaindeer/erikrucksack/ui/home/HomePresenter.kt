package com.captaindeer.erikrucksack.ui.home

import android.util.Log
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemFeatureModel
import com.captaindeer.erikrucksack.data.remote.responses.models.ItemTechModel
import com.captaindeer.erikrucksack.ui.utils.Constants
import com.google.firebase.firestore.FirebaseFirestore

class HomePresenter(private val view: HomeInterface.View) : HomeInterface.Presenter {

    private var firestore: FirebaseFirestore? = null

    override fun itemMiniTechData() {
        firestore = FirebaseFirestore.getInstance()
        firestore!!.collection(Constants.COLLECTION_ITEM_TECHNOLOGIES).get().addOnSuccessListener {
            if (!it.isEmpty) {
                val itemsTechModel = arrayListOf<ItemTechModel>()
                val itemsTechsModel = it.toObjects(ItemTechModel::class.java)
                itemsTechModel.addAll(itemsTechsModel)
                view.setUpdateDataMiniTech(itemsTechModel)
            } else {
                return@addOnSuccessListener
            }
        }
    }

    override fun itemTechData() {
        firestore = FirebaseFirestore.getInstance()
        firestore!!.collection(Constants.COLLECTION_ITEM_TECHNOLOGIES).get().addOnSuccessListener {
            if (!it.isEmpty) {
                val itemsTechModel = arrayListOf<ItemTechModel>()
                val itemsTechsModel = it.toObjects(ItemTechModel::class.java)
                itemsTechModel.addAll(itemsTechsModel)
                Log.e("TAG","Cantidad leida: "+itemsTechModel.toString())
            } else {
                return@addOnSuccessListener
            }
        }
    }

    override fun itemFeature() {
        firestore = FirebaseFirestore.getInstance()
        firestore!!.collection(Constants.COLLECTION_ITEM_FEATURES).get().addOnSuccessListener {
            if (!it.isEmpty){
                val itemFeatures = arrayListOf<ItemFeatureModel>()
                val itemFeatureModel = it.toObjects(ItemFeatureModel::class.java)
                itemFeatures.addAll(itemFeatureModel)
                view.setUpdateDataItemFeature(itemFeatures)
            } else {
                return@addOnSuccessListener
            }
        }
    }

}