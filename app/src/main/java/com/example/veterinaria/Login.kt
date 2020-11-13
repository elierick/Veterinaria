package com.example.veterinaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar:Button = findViewById(R.id.button_ingresar);
        btnIngresar.setOnClickListener(){
            openActivityPets();
        }

        val textviewRegistrase:TextView = findViewById(R.id.textView_Registrarse)
        textviewRegistrase.setOnClickListener(){
            openActivityRegister();
        }

    }


     fun openActivityPets(){

        var intent = Intent(this,MyPets::class.java);
        startActivity(intent)
    }

    fun openActivityRegister(){
        var intent = Intent(this,Register::class.java);
        startActivity(intent)
    }

}