package com.example.rickandmortyapp.common.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity
import com.example.rickandmortyapp.screen_characters.data.local.dao.CharactersDao

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RickDatabase: RoomDatabase() {
    abstract fun charactersDao(): CharactersDao
    companion object {
        const val DATABASE_NAME = "characters.db"
    }
}