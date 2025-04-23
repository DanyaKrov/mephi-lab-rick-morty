package com.example.rickandmortyapp.common.data.local.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity (
    @PrimaryKey
    val id: Int = 0,
    val name: String,
    val status: String,
    val image: String
)