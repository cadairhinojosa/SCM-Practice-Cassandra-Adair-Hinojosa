package com.example.pokeiapi.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeiapi.api.PokeApiInter
import com.example.pokeiapi.api.PokemonInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeVM : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokeApiInter = retrofit.create(PokeApiInter::class.java)

    val pokemonInfo = MutableLiveData<PokemonInfo>()
    val pokemonDescription = MutableLiveData<PokemonInfo>()
    fun getPokemonInfo(id: Int) {
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<PokemonInfo> {
            override fun onResponse(call: Call<PokemonInfo>, response: Response<PokemonInfo>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<PokemonInfo>, t: Throwable) {
                call.cancel()
            }

        })

    }

    fun getPokemonDescription(id: Int) {
        val callDescription = service.getPokemonSpecies(id)
        callDescription.enqueue(object : Callback<PokemonInfo> {
            override fun onResponse(call: Call<PokemonInfo>, response: Response<PokemonInfo>) {
                response.body()?.let { pokemon ->
                    pokemonDescription.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<PokemonInfo>, t: Throwable) {
                call.cancel()
            }

        })
    }
}
