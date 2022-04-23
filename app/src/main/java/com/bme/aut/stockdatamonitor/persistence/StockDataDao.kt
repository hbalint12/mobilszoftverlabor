package hu.bme.aut.android.stockdatamonitor.persistence

import androidx.room.Dao
import androidx.room.Query
import hu.bme.aut.android.stockdatamonitor.model.StockData


@Dao
interface StockDataDao {
    @Query("SELECT * FROM stockData")
    suspend fun getStockDataList(): List<StockData>
}