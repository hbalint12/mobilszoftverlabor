package com.bme.aut.stockdatamonitor.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bme.aut.stockdatamonitor.model.StockData


@Database(entities = [StockData::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun stockDataDao(): StockDataDao
}