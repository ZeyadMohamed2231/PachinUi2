package com.example.pachinui2.backend

import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object FirebaseConn {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val firebaseUser: FirebaseUser? = firebaseAuth.currentUser
    private var database: DatabaseReference= Firebase.database.reference
    const val domain:String="@gmail.com"

    fun writeNewUser(userPhone: String, firstName: String, lastName: String, points:Int,activity: FragmentActivity) {
        val user = User(firstName, lastName ,points)

        database.child("CustomersData").child(userPhone).setValue(user).addOnCompleteListener(activity){task ->
            if (task.isSuccessful){

            }



        }
    }
}