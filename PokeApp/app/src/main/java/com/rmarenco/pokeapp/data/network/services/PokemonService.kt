package com.rmarenco.pokeapp.data.network.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonService {
    private val service: PokeApi =
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)

    suspend fun getPokemons(limit: Int, offset: Int) =
        service.getPokemons(limit, offset)
}