package hu.bme.aut.android.stockdatamonitor.ui.main

import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import hu.bme.aut.android.stockdatamonitor.model.StockData
import hu.bme.aut.android.stockdatamonitor.network.HistoricalDataService
import hu.bme.aut.android.stockdatamonitor.persistence.StockDataDao
import javax.inject.Inject
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess

class MainRepository @Inject constructor(
        private val historicalDataService: HistoricalDataService,
        private val stockDataDao: StockDataDao
){

    @WorkerThread
    fun loadStockData(
            onStart: () -> Unit,
            onCompletion: () -> Unit,
            onError: (String) -> Unit
    ) = flow {
        val stockData: List<StockData> = stockDataDao.getStockDataList()
        if (stockData.isEmpty()) {
            // request API network call asynchronously.
            historicalDataService.fetchStockDataList()
                    // handle the case when the API request gets a success response.
                    .suspendOnSuccess {
                        stockDataDao.insertStockDataList(data)
                        emit(data)
                    }
                    // handle the case when the API request gets an error response.
                    // e.g. internal server error.
                    .onError {
                        onError(message())
                    }
                    // handle the case when the API request gets an exception response.
                    // e.g. network connection error.
                    .onException {
                        onError(message())
                    }
        } else {
            emit(stockData)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(Dispatchers.IO)
}

