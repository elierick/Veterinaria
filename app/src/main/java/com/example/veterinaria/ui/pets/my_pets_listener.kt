package com.example.veterinaria.ui.pets

import com.example.veterinaria.models.Pet

interface my_pets_listener {
    fun onPetsSaved(pet: Pet)
}