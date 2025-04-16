package com.example.examenandroidactivity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examenandroidactivity.pokeDao.PokemonDao

@Database(entities = [PokemonEntity::class], version = 1) // Define las entidades y la versión
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao // Vincula el DAO
}