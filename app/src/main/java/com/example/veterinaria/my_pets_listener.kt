package com.example.veterinaria

interface my_pets_listener {
    abstract val recyclerview: Any

    fun onPetsSaved(Pet: Pet)
}