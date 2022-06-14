package com.example.ecomadmin.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecomadmin.models.Order
import com.example.ecomadmin.models.OrderDetails
import com.example.ecomadmin.models.OrderSettings
import com.example.ecomadmin.utils.*
import com.google.firebase.firestore.FirebaseFirestore

class OrderRepository {
    private val db = FirebaseFirestore.getInstance()

    fun getOrderSettings() : LiveData<OrderSettings> {
        val settingsLD = MutableLiveData<OrderSettings>()
        db.collection(collectionOrderSettings)
            .document(documentOrderSettings)
            .addSnapshotListener { value, error ->
                if (error != null ){
                    return@addSnapshotListener
                }

                settingsLD.value = value!!.toObject(OrderSettings::class.java)
            }
        return settingsLD
    }

    fun addNewOrder(
        order: Order,
        orderDetailsList: MutableList<OrderDetails>,
        callback: (DBResult) -> Unit
    ) {
        val wb = db.batch()
        val orderDoc = db.collection(collectionOrder).document()
        order.orderId = orderDoc.id
        wb.set(orderDoc, order)
        orderDetailsList.forEach {
            val detailsDoc = db.collection(collectionOrder).document(orderDoc.id)
                .collection(collectionOrderDetails).document(it.productId!!)
            wb.set(detailsDoc, it)
        }
        wb.commit()
            .addOnSuccessListener {
                callback(DBResult.SUCCESS)
            }.addOnFailureListener {
                callback(DBResult.FAILURE)
            }
    }

    fun getOrderByUser(userId: String) : LiveData<List<Order>> {
        val orderLD = MutableLiveData<List<Order>>()
        db.collection(collectionOrder)
            .whereEqualTo("userId", userId)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }

                val tempList = mutableListOf<Order>()
                for (doc in value!!.documents) {
                    doc.toObject(Order::class.java)?.let { tempList.add(it) }
                }
                orderLD.value = tempList
            }
        return orderLD
    }
}