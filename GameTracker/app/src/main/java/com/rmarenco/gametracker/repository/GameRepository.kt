package com.rmarenco.gametracker.repository

import com.rmarenco.gametracker.data.Game

class GameRepository(private val games: List<Game>) {
    fun getGames() = games
}