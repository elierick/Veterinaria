package com.example.veterinaria.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.veterinaria.R
import com.example.veterinaria.models.Pet
import java.util.ArrayList

class Adapter_my_pets (var list: ArrayList<Pet>):RecyclerView.Adapter<Adapter_my_pets.ViewHolder>() {

    /*agregamos la subclase/ clase anidada*/
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        /*agregamos el metodo para recibir los datos que vamos a gregar en la vista */
        fun bindItems(data: Pet){
            val nombre: TextView = itemView.findViewById(R.id.textView_Nombres)
            val raza: TextView = itemView.findViewById(R.id.textView_raza)
            val edad: TextView = itemView.findViewById(R.id.textView_Edad)

            nombre.text = data.nombre
            raza.text = data.raza
            edad.text =data.edad.toString()

            /*Agregamos el evento Onclick a cada item*/
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"Item seleccionado: ${data.nombre}", Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        /*creamos la variable de la vista q vamos a inflar*/
        val vista =     LayoutInflater.from(parent.context).inflate(R.layout.pets_items,parent,false)
        return ViewHolder(vista)
    }

}