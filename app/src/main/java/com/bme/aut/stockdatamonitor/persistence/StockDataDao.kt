package hu.bme.aut.android.stockdatamonitor.persistence

import androidx.room.Dao
import androidx.room.Query
import hu.bme.aut.android.stockdatamonitor.model.StockData
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface StockDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStockDataList(stockData: List<StockData>)

    @Query("SELECT * FROM stockData")
    suspend fun getStockDataList(): List<StockData>
}