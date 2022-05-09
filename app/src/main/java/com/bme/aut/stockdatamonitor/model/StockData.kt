package com.bme.aut.stockdatamonitor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable




@Entity
@Immutable
data class StockData(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val date: String,
        val close: Double
){
    companion object {

        fun mock() = StockData(
                id = 1,
                name = "AAPL",
                date = "2022-04-13",
                close = 165.3
        )
    }
}