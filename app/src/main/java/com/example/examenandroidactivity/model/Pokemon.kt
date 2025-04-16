package com.example.examenandroidactivity.model

data class Pokemon(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val results: List<Pokemon>,
    val next: String? // Para la paginación
)

