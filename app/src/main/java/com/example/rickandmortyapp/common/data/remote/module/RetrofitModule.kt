package com.example.rickandmortyapp.common.data.remote.module

import com.example.rickandmortyapp.common.core.Constants
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.CharactersDataSource
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.repository.CharactersDataSourceRepository
import io.ktor.client.HttpClient
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    private val client = OkHttpClient.Builder()
        .build()

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun createCharactersDataSource(): CharactersDataSource {
        return instance.create(CharactersDataSource::class.java)
    }
}