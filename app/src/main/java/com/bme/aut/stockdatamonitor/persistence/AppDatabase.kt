package hu.bme.aut.android.stockdatamonitor.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.stockdatamonitor.model.StockData


@Database(entities = [StockData::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
    abstract fun stockDataDao(): StockDataDao
}