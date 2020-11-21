package com.example.veterinaria.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.veterinaria.MainActivity
import com.example.veterinaria.R
import com.example.veterinaria.helpers.Database
import com.example.veterinaria.helpers.FirebaseHelper
import com.example.veterinaria.models.User

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.button_registrar)
        button.setOnClickListener {
            registrarUser()
        }
    }

    private fun registrarUser() {
        val textEmail: EditText = findViewById(R.id.editTextTextEmail)
        val textPass: EditText = findViewById(R.id.editTextTextPasswordregister)

        FirebaseHelper.auth.createUserWithEmailAndPassword(
            textEmail.text.toString(),
            textPass.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = FirebaseHelper.auth.currentUser
                    val textNombre: EditText = findViewById(R.id.editTextTextNombre)
                    val textApellido: EditText = findViewById(R.id.editTextTextapellidos)
                    val textTelefono: EditText = findViewById(R.id.editTextTexttelefono)
                    val newUser = User(
                        textNombre.text.toString(),
                        textApellido.text.toString(),
                        textTelefono.text.toString(),
                        user!!.uid
                    )
                    FirebaseHelper.db.collection(Database.Users).document(newUser.userId)
                        .set(newUser)
                        .addOnSuccessListener { openActivityHome() }
                        .addOnFailureListener { showRegistrationError() }

                } else {
                    showRegistrationError()
                }
            }
    }

    private fun openActivityHome() {

        var intent = Intent(this, MainActivity::class.java);
        startActivity(intent)
    }

    private fun showRegistrationError() {
        Toast.makeText(
            baseContext, "Authentication failed.",
            Toast.LENGTH_SHORT
        ).show()
    }
}