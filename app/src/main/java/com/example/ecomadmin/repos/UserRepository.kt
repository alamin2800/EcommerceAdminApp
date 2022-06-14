package com.example.ecomadmin.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecomadmin.models.EcomUser
import com.example.ecomadmin.utils.collectionUser
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {
    private val db = FirebaseFirestore.getInstance()
    fun addNewUser(ecomUser: EcomUser) {
        db.collection(collectionUser).document(ecomUser.userId!!)
            .set(ecomUser)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }

    fun updateUserAddress(userId: String, address: String) {
        db.collection(collectionUser).document(userId)
            .update("userAddress", address)
            .addOnSuccessListener {

            }.addOnFailureListener {

            }
    }

    fun getUser(userId: String) : LiveData<EcomUser> {
        val userLD = MutableLiveData<EcomUser>()
        db.collection(collectionUser)
            .document(userId)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }

                userLD.value = value!!.toObject(EcomUser::class.java)
            }
        return userLD
    }

    fun getAllUser() : LiveData<List<EcomUser>> {
        val userLD = MutableLiveData<List<EcomUser>>()
        db.collection(collectionUser)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }

                val temp = mutableListOf<EcomUser>()
                for (doc in value!!.documents) {
                    doc.toObject(EcomUser::class.java)?.let { temp.add(it) }
                }
                userLD.value = temp
            }
        return userLD
    }


}