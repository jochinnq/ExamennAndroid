package com.example.examenandroidactivity.network


import com.example.examenandroidactivity.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<PokemonResponse>
}