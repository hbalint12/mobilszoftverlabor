package com.bme.aut.stockdatamonitor.ui.main

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import com.bme.aut.stockdatamonitor.model.StockData
import com.bme.aut.stockdatamonitor.network.HistoricalDataService
import com.bme.aut.stockdatamonitor.persistence.StockDataDao
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.skydoves.sandwich.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import org.json.JSONObject
import retrofit2.awaitResponse


class MainRepository @Inject constructor(
    private val historicalDataService: HistoricalDataService,
    private val stockDataDao: StockDataDao
){

    @WorkerThread
    fun loadStockData(
            onStart: () -> Unit,
            onCompletion: () -> Unit,
            onError: (String) -> Unit
    ): Flow<List<StockData>> = channelFlow<List<StockData>> {
        val stockData: List<StockData> = stockDataDao.getStockDataList()
        //Log.d("STOCK FETCHED", stockData.get(0).toString())
        var data:  String = ""
        val stockArray: ArrayList<StockData> = arrayListOf()
        if (stockData.isEmpty()) {


            // request API network call asynchronously.
            CoroutineScope(Dispatchers.IO).launch {
                data = historicalDataService.fetchStockDataList().awaitResponse().body()!!.string()
                var gson = Gson()
                val json = (JSONObject(data).get("Time Series (Daily)") as JSONObject)
                var id_cnt = 0
                for (key in json.keys()) {
                    val stockprices = JSONObject(json.get(key).toString())
                    stockArray.add(
                        StockData(
                            id = id_cnt,
                            name = "AAPL",
                            date=key.toString(),
                            close = stockprices.get("4. close").toString().toDouble()
                        ))
                    id_cnt++
                }
                send(stockArray)
                stockDataDao.insertStockDataList(stockArray)
                Log.d("stockArray",stockArray.toString())
            }.start()
            awaitClose()
        } else {
            send(stockData)
            Log.d("stockData", stockData.toString())
        }

    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}

