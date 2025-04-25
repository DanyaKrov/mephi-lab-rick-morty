package com.example.rickandmortyapp.screen_characters.domain.model

data class CharactersModel (
    val error: String? = null,
    val loading: Boolean = false,
    val characters: MutableList<CharacterModel> = mutableListOf()
)