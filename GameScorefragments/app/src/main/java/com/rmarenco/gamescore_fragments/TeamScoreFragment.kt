package com.rmarenco.gamescore_fragments

import android.content.ClipData.Item
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TEAM_NAME = "ARG_TEAM_NAME"
private const val ARG_TEAM_SCORE = "ARG_TEAM_SCORE"


/**
 * A simple [Fragment] subclass.
 * Use the [TeamScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamScoreFragment : Fragment() {

    private var teamName: String? = null
    private var teamScore: Int? = null
    private lateinit var addOneTeam: Button
    private lateinit var displayTeamScore: TextView
    private lateinit var teamNameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            teamName = it.getString(ARG_TEAM_NAME)
            teamScore = it.getInt(ARG_TEAM_SCORE)
        }

        if (savedInstanceState != null) {
            teamScore = savedInstanceState.getInt("$ARG_TEAM_SCORE/_$teamName")
        } else {
            teamScore = 0
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_team_score, container, false)
        bind(view)

        if (savedInstanceState != null) {
            teamScore = savedInstanceState.getInt("${ARG_TEAM_SCORE}_${teamName}")
            teamName = savedInstanceState.getString("${ARG_TEAM_NAME}_${teamName}")

            Log.d("S", savedInstanceState.getInt("${ARG_TEAM_SCORE}_${teamName}").toString())
        }

        displayTeamScore.text = teamScore.toString()
        teamNameText.text = getString(R.string.team_text, teamName)

        addListener()

        return view
    }

    private fun bind(view: View) {
        addOneTeam = view.findViewById(R.id.add_one_team_button)
        displayTeamScore = view.findViewById(R.id.display_score_team_text_view)
        teamNameText = view.findViewById(R.id.team_text)
    }

    private fun addListener() {
        addOneTeam.setOnClickListener {
            teamScore = teamScore?.inc()
            displayTeamScore.text = teamScore.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.apply {
            teamScore?.let { putInt("${ARG_TEAM_SCORE}_${teamName}", it) }
            putString("${ARG_TEAM_NAME}_${teamName}", teamName)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeamScoreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(teamName: String, teamScore: Int) =
            TeamScoreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEAM_NAME, teamName)
                    putInt(ARG_TEAM_SCORE, teamScore)
                }
            }
    }
}