package com.example.rickandmortyapp.screen_characters.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.screen_characters.domain.useCase.RefreshAndGetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val refreshAndGetCharacters: RefreshAndGetCharacters
): ViewModel() {

}