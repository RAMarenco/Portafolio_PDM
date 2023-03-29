package com.rmarenco.shareviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import com.rmarenco.shareviewmodel.ui.MainViewModel
import com.rmarenco.shareviewmodel.ui.lastname.LastnameFragment
import com.rmarenco.shareviewmodel.ui.money.MoneyFragment
import com.rmarenco.shareviewmodel.ui.name.NameFragment

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var backButton: Button
    private lateinit var forwardButton: Button
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        //Estado inicial
        backButton.visibility = View.GONE
        fragmentManager = supportFragmentManager
        addListener()
    }

    private fun addListener() {
        backButton.setOnClickListener {
            viewModel.previousPhase()
            displayPhase(viewModel.currentPhase())
        }

        forwardButton.setOnClickListener {
            viewModel.nextPhase()
            displayPhase(viewModel.currentPhase())
        }
    }

    private fun bind() {
        backButton = findViewById(R.id.back_action)
        forwardButton = findViewById(R.id.forward_action)
    }

    private fun displayPhase(phase: Int) {
        val trans = fragmentManager.beginTransaction()
        when (phase) {
            1 -> {
                trans.replace(R.id.fragment_container, NameFragment())
                    .commit()
                backButton.visibility = View.GONE
            }

            2 -> {
                trans.replace(R.id.fragment_container, LastnameFragment())
                    .commit()
                backButton.visibility = View.VISIBLE
                backButton.visibility = View.VISIBLE
            }

            3 -> {
                trans.replace(R.id.fragment_container, MoneyFragment())
                    .commit()
                forwardButton.visibility = View.GONE
            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.currentPhase() == 1) {
            super.onBackPressed()
        } else {
            viewModel.previousPhase()
            displayPhase(viewModel.currentPhase())
        }
    }
}