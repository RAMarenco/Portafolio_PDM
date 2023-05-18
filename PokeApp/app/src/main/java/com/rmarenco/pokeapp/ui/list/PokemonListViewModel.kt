package com.rmarenco.pokeapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.cachedIn
import com.rmarenco.pokeapp.PokemonApplication
import com.rmarenco.pokeapp.data.models.Pokemon
import com.rmarenco.pokeapp.repositories.PokemonRepository
import kotlinx.coroutines.launch

class PokemonListViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    val pokemons = pokemonRepository
        .getPokemonPage(10)
        .cachedIn(viewModelScope)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PokemonApplication
                PokemonListViewModel(app.pokemonRepository)
            }
        }
    }
}