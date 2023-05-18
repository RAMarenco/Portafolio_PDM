package com.rmarenco.pokeapp.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.rmarenco.pokeapp.data.network.PokemonPagingSources
import com.rmarenco.pokeapp.data.network.services.PokemonService

class PokemonRepository(val pokemonService: PokemonService) {
    suspend fun getPokemons(limit: Int, Offset: Int) =
        pokemonService.getPokemons(limit, Offset)

    fun getPokemonPage(pageSize: Int) = Pager(
        PagingConfig(pageSize)
    ) {
        PokemonPagingSources(pokemonService)
    }.flow
}