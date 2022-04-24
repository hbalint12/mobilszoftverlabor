package hu.bme.aut.android.stockdatamonitor.network

import hu.bme.aut.android.stockdatamonitor.model.StockData
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface HistoricalDataService {
    @GET("StockData2.json")
    suspend fun fetchStockDataList(): ApiResponse<List<StockData>>
}