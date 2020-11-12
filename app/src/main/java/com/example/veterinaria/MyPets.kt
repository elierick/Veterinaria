package com.example.veterinaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyPets : AppCompatActivity(), my_pets_listener {

    val petArrayList = ArrayList<Pet>()
    val recyclerView1: RecyclerView = findViewById(R.id.recyclerview_pets)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_pets)

        /*RECIBIR EL RECYCLERVIEW*/

        recyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        /*creamos la lista de personas - arraylist*/
        petArrayList.add(Pet("DOKY", "Bulldog", 1 ))
        petArrayList.add(Pet("SNUPY", "Chihuahua", 2))
        petArrayList.add(Pet("GORDO", "Bulldog francés", 1))
        petArrayList.add(Pet("SARGENTO", "Pastor alemán", 3))
        petArrayList.add(Pet("DANI", "Gran danés", 2))
        petArrayList.add(Pet("PELOS", "Galgo inglés", 4))
        petArrayList.add(Pet("NOVA", "Terranova", 1))
        petArrayList.add(Pet("FIRU", "Bull terrier", 2))
        actualizarLista();

    }

    fun actualizarLista(){
        /*enviamos la lista al adaptador*/
        val adapter = Adapter_my_pets(petArrayList)

        /*agregarmos el adpatador al recyclerview*/
        recyclerView1.adapter = adapter
        adapter.notifyDataSetChanged();
    }

    override val recyclerview: Any
        get() = TODO("Not yet implemented")

    override fun onPetsSaved(Pet: Pet) {
        petArrayList.add(Pet)
        actualizarLista()
    }

}