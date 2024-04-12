package ru.test.sample.cardbininfotracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.test.sample.database.CardInfoLocalImpl
import ru.test.sample.data.datasource.CardInfoLocal
import ru.test.sample.database.CardInfoDatabase
import ru.test.sample.database.dao.CardInfoDao
import ru.test.sample.database.mapper.CardInfoDataToDatabaseMapper
import ru.test.sample.database.mapper.CardInfoDatabaseToDataMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "card_info_database"

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CardInfoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: CardInfoDatabase) = database.cardInfoDao()

    @Provides
    fun provideCardInfoDatabaseToDataMapper() = CardInfoDatabaseToDataMapper()

    @Provides
    fun provideCardInfoDataToDatabaseMapper() = CardInfoDataToDatabaseMapper()

    @Singleton
    @Provides
    fun provideCardInfoLocal(
        cardInfoDao: CardInfoDao,
        cardInfoDataToDatabaseMapper: CardInfoDataToDatabaseMapper,
        cardInfoDatabaseToDataMapper: CardInfoDatabaseToDataMapper,
    ): CardInfoLocal = CardInfoLocalImpl(
        cardInfoDao,
        cardInfoDataToDatabaseMapper,
        cardInfoDatabaseToDataMapper
    )
}