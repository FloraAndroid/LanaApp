package com.archeticture.flora.lanaapp.motion.model

import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


data class UserInfo(var name:String, var phone:String, var dateO:String) {

    private lateinit var dbReference: DatabaseReference
//some code

    init {
//get reference to the "users" node


    }

     fun createUser() {
         dbReference = FirebaseDatabase.getInstance().getReference("users")
        val clientInfo =UserInfo (name, phone,dateO)
        dbReference.child(phone).setValue(clientInfo).addOnSuccessListener {

           Log.d(Companion.TAG,"create user onSuccess")
        }.addOnCanceledListener {
            Log.d(Companion.TAG,"create user onCancel")
        }
    }

    companion object {
        private const val TAG:String="UsrInfo"
    }


}