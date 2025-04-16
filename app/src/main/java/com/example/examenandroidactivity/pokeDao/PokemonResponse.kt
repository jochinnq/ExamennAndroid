package com.example.examenandroidactivity.pokeDao


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class PokemonResponse(
    val results: List<Pokemon>,
    val next: String?,
    val previous: String?
)
 data class Pokemon(val name: String,
                    val url: String)

//interface PokeApiService {
   // @GET("pokemon")
   // fun getPokemons(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<PokemonResponse>

