package com.example.rickandmortyapp.app

import android.content.Context
import androidx.room.Room
import com.example.rickandmortyapp.common.data.local.database.RickDatabase
import com.example.rickandmortyapp.common.data.remote.module.RetrofitModule
import com.example.rickandmortyapp.common.data.util.CharacterMapper
import com.example.rickandmortyapp.screen_characters.data.local.dao.CharactersDao
import com.example.rickandmortyapp.screen_characters.data.local.dao.repository.CharactersDaoRepository
import com.example.rickandmortyapp.screen_characters.data.local.dao.service.CharactersDaoService
import com.example.rickandmortyapp.screen_characters.data.local.repository.CharactersLocalRepository
import com.example.rickandmortyapp.screen_characters.data.local.service.CharactersLocalService
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.CharactersDataSource
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.repository.CharactersDataSourceRepository
import com.example.rickandmortyapp.screen_characters.data.remote.dataSource.service.CharactersDataSourceService
import com.example.rickandmortyapp.screen_characters.data.remote.repository.CharactersRemoteRepository
import com.example.rickandmortyapp.screen_characters.data.remote.service.CharactersRemoteService
import com.example.rickandmortyapp.screen_characters.data.service.CharactersService
import com.example.rickandmortyapp.screen_characters.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    @Singleton
    fun provideCharacterMapper(): CharacterMapper {
        return CharacterMapper()
    }

    @Provides
    @Singleton
    fun provideCharactersDataSource(): CharactersDataSource {
        return RetrofitModule.createCharactersDataSource()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RickDatabase {
        return Room.databaseBuilder(
            context,
            RickDatabase::class.java,
            "rickmorty_local_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharactersDao(db: RickDatabase): CharactersDao {
        return db.charactersDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryHiltModule {
    @Binds
    @Singleton
    abstract fun bindCharactersDaoRepository(
        impl: CharactersDaoService
    ): CharactersDaoRepository

    @Binds
    @Singleton
    abstract fun bindCharactersDataSourceRepository(
        impl: CharactersDataSourceService
    ): CharactersDataSourceRepository


    @Binds
    @Singleton
    abstract fun bindCharactersLocalRepository(
        impl: CharactersLocalService
    ): CharactersLocalRepository

    @Binds
    @Singleton
    abstract fun bindCharactersRemoteRepository(
        impl: CharactersRemoteService
    ): CharactersRemoteRepository


    @Binds
    @Singleton
    abstract fun bindCharactersRepository(
        impl: CharactersService
    ): CharactersRepository

}