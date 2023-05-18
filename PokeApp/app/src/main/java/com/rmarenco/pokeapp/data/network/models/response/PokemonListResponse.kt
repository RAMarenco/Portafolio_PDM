package com.rmarenco.pokeapp.data.network.models.response

import com.rmarenco.pokeapp.data.models.Pokemon

data class PokemonListResponse(
    val count: String?,
    var next: String?,
    var previous: String?,
    var results: List<Pokemon>
)
