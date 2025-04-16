package com.example.examenandroidactivity.pokeDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.examenandroidactivity.database.PokemonEntity

@Dao
interface PokemonDao {

    // Método para insertar una lista de Pokémon en la base de datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemonList: List<PokemonEntity>)

    // Método para obtener todos los Pokémon desde la base de datos
    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemon(): List<PokemonEntity>
}
