package com.rmarenco.gametracker.ui.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.rmarenco.gametracker.R
import com.rmarenco.gametracker.databinding.FragmentGamesBinding

class GamesFragment : Fragment() {
    private lateinit var binding: FragmentGamesBinding
    private val viewModel: GamesViewModel by viewModels {
        GamesViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_games, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GameAdapter {
            Toast.makeText(requireContext(), "Click en ${it.title}", Toast.LENGTH_LONG).show()
        }
        adapter.submitData(viewModel.getGames())
        Log.d("a", viewModel.getGames().toString())

        binding.recylerViewGames.adapter = adapter
    }
}