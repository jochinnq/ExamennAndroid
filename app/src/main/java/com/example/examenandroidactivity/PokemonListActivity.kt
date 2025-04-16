package com.example.examenandroidactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.examenandroidactivity.adapter.PokemonAdapter
import com.example.examenandroidactivity.database.AppDatabase
import com.example.examenandroidactivity.database.PokemonEntity
import com.example.examenandroidactivity.network.RetrofitClient
import com.example.examenandroidactivity.pokeDao.Pokemon
import com.example.examenandroidactivity.pokeDao.PokemonResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        // Configura RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configura base de datos
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pokemon_database"
        ).build()

        // Carga los datos (API o Room)
        lifecycleScope.launch {
            if (isNetworkAvailable()) {
                loadFromApi()
            } else {
                loadFromRoom()
            }
        }
    }

    private fun isNetworkAvailable(): Boolean {
        // Implementar lógica para verificar conexión a Internet
        return true // Cambia esto según tu implementación
    }

    private fun loadFromApi() {
        RetrofitClient.apiService.getPokemons(0, 20).enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful) {
                    val pokemonList = response.body()?.results ?: emptyList()

                    // Inserta en Room
                    lifecycleScope.launch {
                        val pokemonEntities = pokemonList.map { PokemonEntity(it.name, it.url) }
                        database.pokemonDao().insertAll(pokemonEntities)
                    }

                    // Muestra en el RecyclerView

                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                t.printStackTrace() // Manejar errores
            }
        })
    }

    private fun loadFromRoom() {
        lifecycleScope.launch {
            val cachedPokemons = database.pokemonDao().getAllPokemon()
            val pokemonList = cachedPokemons.map { Pokemon(it.name, it.url) }

        }
    }


    private fun <T> Call<T>.enqueue(callback: Callback<PokemonResponse>) {

    }
}