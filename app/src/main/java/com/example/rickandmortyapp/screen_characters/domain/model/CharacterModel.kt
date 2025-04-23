package com.example.rickandmortyapp.screen_characters.domain.model

import android.net.Uri

data class CharacterModel (
    val name: String,
    val image: Uri,
    val status: String
)