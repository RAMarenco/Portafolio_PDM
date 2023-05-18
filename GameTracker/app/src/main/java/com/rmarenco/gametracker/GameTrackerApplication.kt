package com.rmarenco.gametracker

import android.app.Application
import com.rmarenco.gametracker.data.games
import com.rmarenco.gametracker.repository.GameRepository

class GameTrackerApplication: Application() {
    val gameRepository: GameRepository by lazy {
        GameRepository(games)
    }
}