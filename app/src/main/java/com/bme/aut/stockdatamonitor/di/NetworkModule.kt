package hu.bme.aut.android.stockdatamonitor.di

import android.content.Context
import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import hu.bme.aut.android.stockdatamonitor.network.RequestInterceptor
import coil.util.CoilUtils
import hu.bme.aut.android.stockdatamonitor.coroutines.CoroutinesResponseCallAdapterFactory



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .cache(CoilUtils.createDefaultCache(context))
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(
                        "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=AAPL&apikey=R9RRIPY5ZHSNL3X6\n"
                )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideHistoricalDataService(retrofit: Retrofit): HistoricalDataService {
        return retrofit.create(HistoricalDataService::class.java)
    }
}