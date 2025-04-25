package com.example.rickandmortyapp.screen_characters.data.local.service

import android.util.Log
import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity
import com.example.rickandmortyapp.screen_characters.data.local.dao.repository.CharactersDaoRepository
import com.example.rickandmortyapp.screen_characters.data.local.repository.CharactersLocalRepository
import javax.inject.Inject

class CharactersLocalService @Inject constructor(
    private val dao: CharactersDaoRepository
): CharactersLocalRepository {
    override suspend fun getAllCharacters(): List<CharacterEntity> =
        dao.getAllCharacters()

    override suspend fun createCharacters(characters: List<CharacterEntity>) {
        dao.createCharacters(characters)
    }

    override suspend fun deleteAllCharacters(): Boolean =
        dao.deleteAllCharacters()
}