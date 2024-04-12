package ru.test.sample.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info")
data class CardInfoEntity(
    @Embedded val number: CardNumberEntity,
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    @Embedded val country: CountryEntity,
    @Embedded val bank: BankEntity,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
