package com.example.examenandroidactivity.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroidactivity.R
import com.example.examenandroidactivity.model.Pokemon


class PokemonAdapter(
    private val pokemonList: List<Pokemon>,
    private val onClick: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon, onClick)
    }

    override fun getItemCount(): Int = pokemonList.size

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(android.R.id.text1)

        fun bind(pokemon: Pokemon, onClick: (Pokemon) -> Unit) {
            textView.text = pokemon.name
            itemView.setOnClickListener { onClick(pokemon) }
        }
    }
}