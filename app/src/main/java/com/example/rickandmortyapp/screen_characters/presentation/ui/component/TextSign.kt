package com.example.rickandmortyapp.screen_characters.presentation.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TextSign(text: String) {
    val character = null
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium
    )
}