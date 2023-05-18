package com.rmarenco.pokeapp

import android.app.Application
import com.rmarenco.pokeapp.data.network.services.PokemonService
import com.rmarenco.pokeapp.repositories.PokemonRepository

class PokemonApplication : Application() {
    private val pokemonService by lazy {
        PokemonService()
    }

    val pokemonRepository by lazy {
        PokemonRepository(pokemonService)
    }
}