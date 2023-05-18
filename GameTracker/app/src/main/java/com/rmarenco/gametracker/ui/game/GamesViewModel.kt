package com.rmarenco.gametracker.ui.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rmarenco.gametracker.GameTrackerApplication
import com.rmarenco.gametracker.repository.GameRepository

class GamesViewModel(private val repository: GameRepository) : ViewModel() {
    fun getGames() = repository.getGames()

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as GameTrackerApplication
                GamesViewModel(app.gameRepository)
            }
        }
    }
}