package com.example.rickandmortyapp.screen_characters.data.local.dao.service

import android.util.Log
import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity
import com.example.rickandmortyapp.screen_characters.data.local.dao.CharactersDao
import com.example.rickandmortyapp.screen_characters.data.local.dao.repository.CharactersDaoRepository
import javax.inject.Inject

class CharactersDaoService @Inject constructor(
    private val dao: CharactersDao
): CharactersDaoRepository {
    override suspend fun getAllCharacters(): List<CharacterEntity> =
        dao.getAllCharacters()

    override suspend fun getCharacterById(id: Int): CharacterEntity=
        dao.getCharacterById(id)

    override suspend fun getCharacterByName(name: String): CharacterEntity =
        dao.getCharacterByName(name)

    override suspend fun createCharacter(characterEntity: CharacterEntity) {
        dao.createCharacter(characterEntity)
    }

    override suspend fun createCharacters(characters: List<CharacterEntity>) {
        dao.insertAll(characters)
    }

    override suspend fun deleteAllCharacters(): Boolean {
        return try {
            dao.deleteAllCharacters()
            true
        }
        catch (_: Exception) {
            false
        }
    }
}