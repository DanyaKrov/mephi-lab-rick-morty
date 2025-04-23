package com.example.rickandmortyapp.screen_characters.domain.model

data class CharactersModel (
    val error: String = "",
    val characters: List<CharacterModel>
)