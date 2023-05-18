package com.rmarenco.gametracker.ui.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rmarenco.gametracker.R
import com.rmarenco.gametracker.data.Game

class GameAdapter(private val onClickBook: (Game) -> Unit) :
    RecyclerView.Adapter<GameAdapter.ViewHolderBook>() {

    private var games: List<Game>? = null

    class ViewHolderBook(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game, onClickBook: (Game) -> Unit) {
            val gameItem: LinearLayout = itemView.findViewById(R.id.game_item)
            val titleTextView: TextView = itemView.findViewById(R.id.game_title)
            val publisherTextView: TextView = itemView.findViewById(R.id.game_publisher)
            titleTextView.text = game.title
            publisherTextView.text = game.publisher.name
            gameItem.setOnClickListener {
                onClickBook(game)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderBook {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.gameitem_view, parent, false)
        return ViewHolderBook(view)
    }

    override fun getItemCount(): Int = games?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderBook, position: Int) {
        games?.let {
            holder.bind(it[position], onClickBook)
        }
    }

    fun submitData(games: List<Game>) {
        this.games = games
    }
}