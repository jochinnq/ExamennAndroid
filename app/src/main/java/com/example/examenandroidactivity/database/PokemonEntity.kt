package com.example.examenandroidactivity.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")

data class PokemonEntity(
    @PrimaryKey val name: String,
    val url: String
)
