package com.example.pokeiapi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokeiapi.databinding.ActivityMainBinding
import com.example.pokeiapi.model.PokeLAdapter
import com.example.pokeiapi.model.PokeLVM

 class PokeList : AppCompatActivity() {
     private lateinit var viewModel: PokeLVM
     private lateinit var binding: ActivityMainBinding
     private lateinit var pokeListAdapter: PokeLAdapter


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         viewModel = ViewModelProvider(this)[PokeLVM::class.java]

         initUI()
     }

     private fun initUI() {
         binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(this)


         pokeListAdapter = PokeLAdapter{
             val intent = Intent(this, MainActivity::class.java)
             intent.putExtra("id", it)
             startActivity(intent)
         }


         binding.pokelistRecyclerView.adapter = pokeListAdapter

         viewModel.getPokemonList()
         viewModel.pokemonList.observe(this, Observer { list ->
             pokeListAdapter.setData(list)
         })
     }
 }
