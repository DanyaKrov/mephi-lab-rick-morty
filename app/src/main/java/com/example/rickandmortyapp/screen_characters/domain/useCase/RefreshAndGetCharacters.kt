package com.example.rickandmortyapp.screen_characters.domain.useCase

import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel
import com.example.rickandmortyapp.screen_characters.domain.repository.CharactersRepository
import javax.inject.Inject

class RefreshAndGetCharacters @Inject constructor(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(forceRefresh: Boolean = false): List<CharacterModel> =
        repository.getAllCharacters(forceRefresh)
}