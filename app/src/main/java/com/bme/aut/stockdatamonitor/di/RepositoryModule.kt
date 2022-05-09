package hu.bme.aut.android.stockdatamonitor.di


import com.bme.aut.stockdatamonitor.network.HistoricalDataService
import com.bme.aut.stockdatamonitor.persistence.StockDataDao
import com.bme.aut.stockdatamonitor.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        historicalDataService: HistoricalDataService,
        stockDataDao: StockDataDao
    ): MainRepository {
        return MainRepository(historicalDataService, stockDataDao)
    }
}