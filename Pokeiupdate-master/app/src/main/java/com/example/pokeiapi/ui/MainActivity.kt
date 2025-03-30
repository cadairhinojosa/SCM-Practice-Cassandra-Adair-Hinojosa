package com.example.pokeiapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeiapi.R
import com.example.pokeiapi.databinding.PokeInfoBinding
import com.example.pokeiapi.model.PokeVM
import com.example.pokeiapi.databinding.PokeListBinding
import com.example.pokeiapi.model.PokeLAdapter


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: PokeVM
    private lateinit var binding: PokeInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PokeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PokeVM::class.java]


        initUI()


    }

    private fun initUI() {
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            val typeNames = pokemon.types.map { it.type.name }
            binding.nametv.text = pokemon.name
            binding.ht.text = "Height: ${pokemon.height / 10.0}m"
            binding.wt.text = "Weight: ${pokemon.weight / 10.0}"

            binding.tt.text = "Tip: ${typeNames.joinToString()}"
            binding.expt.text = "Exp.Base: ${pokemon.baseExperience}"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(binding.imageView)
        })

        viewModel.getPokemonDescription(id)
        viewModel.pokemonDescription.observe(this) { pokemon ->


            val englishEntries = pokemon.flavorTextEntries.filter { it.language.name == "en" }

            val englishText = englishEntries.firstOrNull()?.flavorText

            binding.dt.text = englishText ?: ""

            viewModel.pokemonInfo.value?.englishFlavorTextEntries =
                englishEntries.map { it.flavorText }
        }
    }
}