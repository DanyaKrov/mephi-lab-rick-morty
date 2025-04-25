package com.example.rickandmortyapp.screen_characters.data.local.dao.service

import android.util.Log
import com.example.rickandmortyapp.common.data.remote.module.RetrofitModule
import com.example.rickandmortyapp.screen_characters.data.local.dao.CharactersDao
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.CharactersDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runTest


class CharactersDaoServiceTest {
    private lateinit var dataSource: CharactersDataSource
    @Before
    fun setUp() {
        dataSource = RetrofitModule.createCharactersDataSource()
    }

    @Test
    fun test(): Unit = runBlocking {
        val result = dataSource.getAllCharacters()
        Log.e("testing", result.toString())
    }
}