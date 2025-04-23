package com.example.rickandmortyapp.screen_characters.data.remote.repository

import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse

interface CharactersRemoteRepository {
    suspend fun getAllCharacters(): List<CharacterRemoteResponse>
}