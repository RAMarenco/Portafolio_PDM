package com.rmarenco.pokeapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rmarenco.pokeapp.R
import com.rmarenco.pokeapp.data.models.Pokemon

class PokemonAdapter(differCallback: DiffUtil.ItemCallback<Pokemon>) :
    PagingDataAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(differCallback) {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imagePokemon: ImageView = itemView.findViewById(R.id.pokemonImage)
        private val namePokemon: TextView = itemView.findViewById(R.id.pokemonName)

        fun bind(pokemon: Pokemon?) {
            namePokemon.text = pokemon?.name ?: "Pokemon"
            val id = pokemon?.let { pokemon ->
                pokemon.image.split("/").asReversed()[1]
            } ?: 1
            Glide
                .with(itemView)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png")
                .into(imagePokemon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object PokemonComparator : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}