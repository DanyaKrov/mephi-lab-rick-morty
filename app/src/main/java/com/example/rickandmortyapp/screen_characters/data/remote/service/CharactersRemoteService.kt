package com.example.rickandmortyapp.screen_characters.data.remote.service

import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.repository.CharactersDataSourceRepository
import com.example.rickandmortyapp.screen_characters.data.remote.repository.CharactersRemoteRepository
import javax.inject.Inject

class CharactersRemoteService @Inject constructor(
    private val dataSource: CharactersDataSourceRepository
): CharactersRemoteRepository {
    override suspend fun getAllCharacters(): List<CharacterRemoteResponse> =
        dataSource.getAllCharacters().results
}