package com.example.veterinaria.ui.pets

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.adapters.Adapter_my_pets
import com.example.veterinaria.R
import com.example.veterinaria.models.Pet

class MyPets: Fragment(), my_pets_listener {
     val petArrayList = ArrayList<Pet>();

    @SuppressLint("WrongConstant")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_pets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*RECIBIR EL RECYCLERVIEW*/
        val recyclerView1: RecyclerView = view.findViewById(R.id.recyclerview_pets)
        recyclerView1.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)

        /*creamos la lista de personas - arraylist*/
        petArrayList.add(Pet("DOKY", "Bulldog", 1 ))
        petArrayList.add(Pet("SNUPY", "Chihuahua", 2))
        petArrayList.add(Pet("GORDO", "Bulldog francés", 1))
        petArrayList.add(Pet("SARGENTO", "Pastor alemán", 3))
        petArrayList.add(Pet("DANI", "Gran danés", 2))
        petArrayList.add(Pet("PELOS", "Galgo inglés", 4))
        petArrayList.add(Pet("NOVA", "Terranova", 1))
        petArrayList.add(Pet("FIRU", "Bull terrier", 2))
        actualizarLista(view);
    }

    fun actualizarLista(view: View){
        /*enviamos la lista al adaptador*/
        val adapter = Adapter_my_pets(petArrayList)
        val recyclerView1: RecyclerView = view.findViewById(R.id.recyclerview_pets)
        /*agregarmos el adpatador al recyclerview*/
        recyclerView1.adapter = adapter
        adapter.notifyDataSetChanged();
    }

    override fun onPetsSaved(pet: Pet) {
        TODO("Not yet implemented")
    }

    /*override fun onPetsSaved(pet: Pet) {
        petArrayList.add(pet)
        actualizarLista()
    }*/

}