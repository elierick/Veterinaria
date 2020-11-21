package com.example.veterinaria.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.veterinaria.MainActivity
import com.example.veterinaria.R
import com.example.veterinaria.helpers.FirebaseHelper
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar: Button = findViewById(R.id.button_ingresar)
        btnIngresar.setOnClickListener {
            login()
        }

        val textviewRegistrase: TextView = findViewById(R.id.textView_Registrarse)
        textviewRegistrase.setOnClickListener {
            openActivityRegister()
        }

        FirebaseHelper.auth = Firebase.auth
        FirebaseHelper.db = FirebaseFirestore.getInstance()
    }

    private fun login() {
        val textEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val textPassword: EditText = findViewById(R.id.editTextTextPassword)

        FirebaseHelper.auth.signInWithEmailAndPassword(
            textEmail.text.toString(),
            textPassword.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    openActivityHome()
                } else {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }

    private fun openActivityHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun openActivityRegister() {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

}