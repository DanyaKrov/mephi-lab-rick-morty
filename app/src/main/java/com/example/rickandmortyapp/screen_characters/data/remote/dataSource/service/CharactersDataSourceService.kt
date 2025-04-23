package com.example.rickandmortyapp.screen_characters.data.remote.dataSource.service

import com.example.rickandmortyapp.common.data.remote.model.response.CharacterListRemoteResponse
import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.CharactersDataSource
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.repository.CharactersDataSourceRepository
import javax.inject.Inject

class CharactersDataSourceService @Inject constructor(
    private val dataSource: CharactersDataSource
): CharactersDataSourceRepository {
    override suspend fun getAllCharacters(): CharacterListRemoteResponse =
        dataSource.getAllCharacters()


    override suspend fun getCharacterById(id: Int): CharacterRemoteResponse =
        dataSource.getCharacterById(id)
}