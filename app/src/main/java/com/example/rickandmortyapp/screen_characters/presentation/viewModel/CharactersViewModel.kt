package com.example.rickandmortyapp.screen_characters.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel
import com.example.rickandmortyapp.screen_characters.domain.model.CharactersModel
import com.example.rickandmortyapp.screen_characters.domain.model.Resource
import com.example.rickandmortyapp.screen_characters.domain.useCase.RefreshAndGetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val refreshAndGetCharacters: RefreshAndGetCharacters
): ViewModel() {
    private val _model: MutableState<CharactersModel> = mutableStateOf(CharactersModel())
    val model: State<CharactersModel> = _model

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }


    private suspend fun getCharacters() {
        refreshAndGetCharacters()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> result.data?.let {
                        _model.value = CharactersModel(
                            characters = result.data.toMutableList())
                    }

                    is Resource.Loading -> _model.value = CharactersModel(loading = true)

                    is Resource.Error -> {
                        _model.value = CharactersModel(error = result.toString(),
                            loading = false
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
}