package com.example.rickandmortyapp.screen_characters.data.local.dao.service

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

    override suspend fun createCharacter(characterEntity: CharacterEntity) =
        dao.createCharacter(characterEntity)

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