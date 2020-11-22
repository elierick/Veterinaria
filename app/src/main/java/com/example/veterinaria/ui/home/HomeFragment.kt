package com.example.veterinaria.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.veterinaria.R

class HomeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val routview:View = inflater.inflate(R.layout.fragment_home, container, false)
        val botonnmascotas: ImageButton = routview.findViewById(R.id.btnmascotas) as ImageButton
        val btncitas: ImageButton = routview.findViewById(R.id.btncitas) as ImageButton
        val btnconsejos: ImageButton = routview.findViewById(R.id.btnconsejos) as ImageButton
        val btnrecord: ImageButton = routview.findViewById(R.id.btnrecord) as ImageButton

        botonnmascotas.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_nav_home_to_nav_mypets)
        }
        btncitas.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_nav_home_to_nav_citas)
        }
            btnconsejos.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_nav_home_to_consejosFragment)
        }

        btnrecord.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_nav_home_to_nav_recordatorio)
        }
        return routview
    }


}