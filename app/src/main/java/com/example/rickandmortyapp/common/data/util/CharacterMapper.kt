package com.example.rickandmortyapp.common.data.util

import android.net.Uri
import android.util.Log
import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity
import com.example.rickandmortyapp.common.data.remote.model.response.CharacterRemoteResponse
import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel

class CharacterMapper {
    fun fromRemoteToEntity(character: CharacterRemoteResponse): CharacterEntity =
        CharacterEntity(
            name = character.name,
            status = character.status,
            image = character.image
        )

    fun fromRemoteToModel(character: CharacterRemoteResponse): CharacterModel {
        Log.i("testing", character.toString())
        return         CharacterModel(
            name = character.name,
            status = character.status,
            image = Uri.parse(character.image)
        )
    }

    fun fromEntityToModel(character: CharacterEntity): CharacterModel =
        CharacterModel(
            name = character.name,
            status = character.status,
            image = Uri.parse(character.image)
        )
}