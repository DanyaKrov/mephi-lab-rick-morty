package com.example.rickandmortyapp.common.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListRemoteResponse (
    val info: CharacterListInfoRemoteResponse,
    val results: List<CharacterRemoteResponse>
)