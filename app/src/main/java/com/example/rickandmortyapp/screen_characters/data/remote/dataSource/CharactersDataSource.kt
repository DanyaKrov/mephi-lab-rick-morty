package com.example.rickandmortyapp.screen_characters.data.remote.dataSource

import com.example.rickandmortyapp.common.data.remote.model.response.CharacterListRemoteResponse
import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CharactersDataSource {
    @POST("/character")
    suspend fun getAllCharacters(): CharacterListRemoteResponse

    @POST("/character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterRemoteResponse
}