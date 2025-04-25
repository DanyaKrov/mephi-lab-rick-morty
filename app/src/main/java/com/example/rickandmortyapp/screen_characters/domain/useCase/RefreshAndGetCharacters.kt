package com.example.rickandmortyapp.screen_characters.domain.useCase

import android.util.Log
import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel
import com.example.rickandmortyapp.screen_characters.domain.model.Resource
import com.example.rickandmortyapp.screen_characters.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshAndGetCharacters @Inject constructor(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false):
            Flow<Resource<List<CharacterModel>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getAllCharacters(forceRefresh)
            emit(Resource.Success(result))
        }
        catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error occurred"))
        }

    }
}