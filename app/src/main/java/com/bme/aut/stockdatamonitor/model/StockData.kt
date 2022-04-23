package hu.bme.aut.android.stockdatamonitor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable


@Entity
@Immutable
data class StockData(
    @PrimaryKey val name: String,
    val date: String,
    val close: Double
){

    companion object {

        fun mock() = StockData(
                name = "AAPL",
                date = "2022-04-13",
                close = 165.3
        )
    }
}