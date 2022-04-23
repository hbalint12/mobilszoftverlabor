package hu.bme.aut.android.stockdatamonitor.network

import hu.bme.aut.android.stockdatamonitor.model.StockData
import retrofit2.http.GET

interface HistoricalDataService {
    //@GET("StockData2.json")
    suspend fun fetchStockDataList()
}