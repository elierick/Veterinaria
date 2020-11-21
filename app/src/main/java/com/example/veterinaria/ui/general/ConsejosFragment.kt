package com.example.veterinaria.ui.general

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.veterinaria.R


/**
 * A simple [Fragment] subclass.
 * Use the [ConsejosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConsejosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         val routview:View = inflater.inflate(R.layout.fragment_consejos, container, false)
         val btnpulgas:Button= routview.findViewById(R.id.btnpulgas) as Button
         val btnesteri:Button= routview.findViewById(R.id.btnesteri) as Button

                btnpulgas.setOnClickListener { view ->
                    view.findNavController().navigate(R.id.action_nav_consejos_to_nav_pulgas)
                }
                btnesteri.setOnClickListener { view ->
                    view.findNavController().navigate(R.id.action_nav_consejos_to_nav_esteril)
        }
                return routview
    }



}