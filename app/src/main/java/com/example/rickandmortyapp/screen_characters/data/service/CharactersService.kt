package com.example.rickandmortyapp.screen_characters.data.service

import android.util.Log
import com.example.rickandmortyapp.common.data.util.CharacterMapper
import com.example.rickandmortyapp.screen_characters.data.local.repository.CharactersLocalRepository
import com.example.rickandmortyapp.screen_characters.data.remote.repository.CharactersRemoteRepository
import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel
import com.example.rickandmortyapp.screen_characters.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersService @Inject constructor(
    private val localRepository: CharactersLocalRepository,
    private val remoteRepository: CharactersRemoteRepository,
    private val mapper: CharacterMapper
): CharactersRepository {
    override suspend fun getAllCharacters(refreshCharacters: Boolean): List<CharacterModel> {
        return if(refreshCharacters) {
            localRepository.deleteAllCharacters()
            loadRemoteToLocalData()
        } else {
            val localCharacters = localRepository.getAllCharacters()
            if (localCharacters.isEmpty()) {
                loadRemoteToLocalData()
            } else {
                localCharacters.map { mapper.fromEntityToModel(it) }
            }
        }
    }

    private suspend fun loadRemoteToLocalData(): List<CharacterModel> {
        val remoteCharacters = remoteRepository.getAllCharacters()
        localRepository.createCharacters(remoteCharacters.map { mapper.fromRemoteToEntity(it) })
        Log.i("testing", localRepository.getAllCharacters().toString())
        return remoteCharacters.map { mapper.fromRemoteToModel(it) }
    }
}