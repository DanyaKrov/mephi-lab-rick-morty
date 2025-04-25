package com.example.rickandmortyapp.screen_characters.data.local.dao.repository

import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity

interface CharactersDaoRepository {
    suspend fun getAllCharacters(): List<CharacterEntity>
    suspend fun getCharacterById(id: Int): CharacterEntity
    suspend fun getCharacterByName(name: String): CharacterEntity
    suspend fun createCharacter(characterEntity: CharacterEntity)
    suspend fun deleteAllCharacters(): Boolean
    suspend fun createCharacters(characters: List<CharacterEntity>)
}