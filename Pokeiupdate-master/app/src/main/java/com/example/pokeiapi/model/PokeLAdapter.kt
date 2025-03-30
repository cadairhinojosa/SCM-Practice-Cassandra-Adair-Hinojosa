package com.example.pokeiapi.model

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeiapi.api.PokeResult
import com.example.pokeiapi.databinding.PokeListBinding

class PokeLAdapter (private val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokeLAdapter.SearchViewHolder>() {
    private var pokemonList: List<PokeResult> = emptyList<PokeResult>()

    fun setData(list: List<PokeResult>) {
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = PokeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val binding = holder.binding
        val pokemon = pokemonList[position]

        binding.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1)
            Toast.makeText(holder.itemView.context, "PokeInfo for position $position: I choose You ${pokemon.name}!", Toast.LENGTH_SHORT).show()}
    }

    class SearchViewHolder(val binding: PokeListBinding): RecyclerView.ViewHolder(binding.root)


}