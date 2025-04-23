package com.example.rickandmortyapp.screen_characters.data.remote.dataSource.repository

import com.example.rickandmortyapp.common.data.remote.model.response.CharacterListRemoteResponse
import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse

interface CharactersDataSourceRepository {
    suspend fun getAllCharacters(): CharacterListRemoteResponse
    suspend fun getCharacterById(id: Int): CharacterRemoteResponse
}