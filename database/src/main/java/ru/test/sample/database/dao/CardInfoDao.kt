package ru.test.sample.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.test.sample.database.entity.CardInfoEntity

@Dao
interface CardInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardInfo: CardInfoEntity)

    @Query("SELECT * FROM card_info ORDER BY id ASC")
    fun getAllCards(): Flow<List<CardInfoEntity>>
}