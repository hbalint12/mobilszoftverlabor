package hu.bme.aut.android.stockdatamonitor.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.stockdatamonitor.network.HistoricalDataService
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideDisneyService(retrofit: Retrofit): HistoricalDataService {
        return retrofit.create(HistoricalDataService::class.java)
    }
}