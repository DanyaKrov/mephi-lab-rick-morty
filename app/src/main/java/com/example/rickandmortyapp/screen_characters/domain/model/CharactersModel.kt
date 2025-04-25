package com.example.rickandmortyapp.screen_characters.domain.model

data class CharactersModel (
    val error: String = "",
    val loading: Boolean = false,
    val characters: MutableList<CharacterModel> = mutableListOf()
)