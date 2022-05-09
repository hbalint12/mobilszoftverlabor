package com.bme.aut.stockdatamonitor.persistence

import com.bme.aut.stockdatamonitor.model.StockData
import org.hamcrest.core.Is.`is`
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.hamcrest.MatcherAssert.assertThat


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class StockDataDaoTest : LocalDatabase() {

  private lateinit var stockDao: StockDataDao

  @Before
  fun init() {
    stockDao = db.stockDataDao()
  }

  @Test
  fun insertAndLoadPosterListTest() = runBlocking {
    val mockDataList = listOf(StockData.mock())
    stockDao.insertStockDataList(mockDataList)

    val loadFromDB = stockDao.getStockDataList()
    assertThat(loadFromDB.toString(), `is`(mockDataList.toString()))

    val mockData = StockData.mock()
    assertThat(loadFromDB[0].toString(), `is`(mockData.toString()))
  }
}