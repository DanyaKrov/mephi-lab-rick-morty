package com.example.rickandmortyapp.screen_characters.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmortyapp.screen_characters.presentation.ui.component.CharacterList
import com.example.rickandmortyapp.screen_characters.presentation.ui.component.TextSign
import com.example.rickandmortyapp.screen_characters.presentation.viewModel.CharactersViewModel
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme

@Preview(showBackground = true)
@Composable
fun MainScreen(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val model = viewModel.model
    RickAndMortyAppTheme {
        if (!model.value.error.isNullOrBlank())
            TextSign(model.value.error.toString())
        else if (model.value.loading)
            TextSign("Loading content")
        else
            CharacterList(characters = model.value.characters)
    }
}