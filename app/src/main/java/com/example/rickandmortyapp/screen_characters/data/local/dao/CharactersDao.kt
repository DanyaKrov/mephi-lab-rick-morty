package com.example.rickandmortyapp.screen_characters.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapp.common.data.local.model.entity.CharacterEntity

@Dao
interface CharactersDao {
    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM characters where id=:id")
    suspend fun getCharacterById(id: Int): CharacterEntity

    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacters()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createCharacter(characterEntity: CharacterEntity)
}