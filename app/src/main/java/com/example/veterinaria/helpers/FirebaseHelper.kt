package com.example.veterinaria.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseHelper {
    companion object {
        lateinit var auth: FirebaseAuth
        lateinit var db: FirebaseFirestore
    }
}