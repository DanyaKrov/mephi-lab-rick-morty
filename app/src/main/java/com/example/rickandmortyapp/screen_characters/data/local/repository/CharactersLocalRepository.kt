package com.example.rickandmortyapp.screen_characters.data.local.repository

import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity

interface CharactersLocalRepository {
    suspend fun getAllCharacters(): List<CharacterEntity>
    suspend fun createCharacters(characters: List<CharacterEntity>)
    suspend fun deleteAllCharacters(): Boolean
}