package com.example.rickandmortyapp.common.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterRemoteResponse (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)