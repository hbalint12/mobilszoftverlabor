package hu.bme.aut.android.stockdatamonitor.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.android.stockdatamonitor.model.StockData


@Dao
interface StockDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStockDataList(posters: List<StockData>)

    @Query("SELECT * FROM StockData WHERE name = :name")
    suspend fun getStockData(name: String): StockData?

    @Query("SELECT * FROM StockData")
    suspend fun getStockDataList(): List<StockData>
}