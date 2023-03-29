package com.rmarenco.gamescore_fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //UI Elements
    private lateinit var gameOverButton: Button

    //Data Elements
    private var scoreTeamA = 0
    private var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentA = TeamScoreFragment.newInstance("A", 0)
            val fragmentB = TeamScoreFragment.newInstance("B", 0)

            supportFragmentManager.beginTransaction()
                .replace(R.id.team_a_fragment, fragmentA)
                .replace(R.id.team_b_fragment, fragmentB)
                .commit()
        }
        bind()
        addListener()
    }

    private fun bind() {
        gameOverButton = findViewById(R.id.game_over_action)
    }

    private fun addListener() {
        gameOverButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(TEAM_A_SCORE, scoreTeamA)
            intent.putExtra(TEAM_B_SCORE, scoreTeamB)

            startActivity(intent)
        }
    }

    companion object {
        const val TEAM_A_SCORE = "TEAM_A_SCORE"
        const val TEAM_B_SCORE = "TEAM_B_SCORE"
    }
}