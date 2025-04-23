package com.example.rickandmortyapp.screen_characters.data.local.service

import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity
import com.example.rickandmortyapp.screen_characters.data.local.dao.repository.CharactersDaoRepository
import com.example.rickandmortyapp.screen_characters.data.local.repository.CharactersLocalRepository
import javax.inject.Inject

class CharactersLocalService @Inject constructor(
    private val dao: CharactersDaoRepository
): CharactersLocalRepository {
    override suspend fun getAllCharacters(): List<CharacterEntity> =
        dao.getAllCharacters()

    override suspend fun createCharacters(characters: List<CharacterEntity>) =
        characters.forEach { dao.createCharacter(it) }

    override suspend fun deleteAllCharacters(): Boolean =
        dao.deleteAllCharacters()
}