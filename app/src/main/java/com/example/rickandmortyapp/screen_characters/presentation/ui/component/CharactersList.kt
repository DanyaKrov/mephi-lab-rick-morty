package com.example.rickandmortyapp.screen_characters.presentation.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.screen_characters.domain.model.CharacterModel

@Composable
fun CharacterList(
    characters: List<CharacterModel>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(characters) { character ->
            CharacterItem(character)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}