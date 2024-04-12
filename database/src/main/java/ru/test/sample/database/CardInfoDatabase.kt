package ru.test.sample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.test.sample.database.dao.CardInfoDao
import ru.test.sample.database.entity.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 1, exportSchema = false)
abstract class CardInfoDatabase : RoomDatabase() {

    abstract fun cardInfoDao(): CardInfoDao
}