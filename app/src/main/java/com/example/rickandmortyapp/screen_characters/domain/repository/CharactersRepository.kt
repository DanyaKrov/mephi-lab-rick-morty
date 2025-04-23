package com.example.rickandmortyapp.screen_characters.domain.repository

import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel

interface CharactersRepository {
    suspend fun getAllCharacters(refreshCharacters: Boolean): List<CharacterModel>
}