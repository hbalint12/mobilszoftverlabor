package com.bme.aut.stockdatamonitor.network

import com.bme.aut.stockdatamonitor.model.StockData
import com.skydoves.sandwich.ApiResponse
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface HistoricalDataService {
    @GET("/query?function=TIME_SERIES_DAILY&symbol=AAPL&apikey=R9RRIPY5ZHSNL3X6")
    fun fetchStockDataList(): Call<ResponseBody>
}