package hu.bme.aut.android.stockdatamonitor.ui.main

import androidx.annotation.WorkerThread
import hu.bme.aut.android.stockdatamonitor.model.StockData
import hu.bme.aut.android.stockdatamonitor.network.HistoricalDataService
import hu.bme.aut.android.stockdatamonitor.persistence.StockDataDao
import javax.inject.Inject

class MainRepository @Inject constructor(
        private val historicalDataService: HistoricalDataService,
        private val stockDataDao: StockDataDao
)
