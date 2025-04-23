package com.example.rickandmortyapp.common.data.remote.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListInfoRemoteResponse (
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)