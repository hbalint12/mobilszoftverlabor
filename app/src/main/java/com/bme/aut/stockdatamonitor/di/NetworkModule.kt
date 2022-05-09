package hu.bme.aut.android.stockdatamonitor.di

import android.content.ClipData.Item
import android.content.Context
import com.bme.aut.stockdatamonitor.model.StockData
import com.bme.aut.stockdatamonitor.network.HistoricalDataService
import com.bme.aut.stockdatamonitor.network.RequestInterceptor
import com.google.gson.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(
                        "https://www.alphavantage.co/"
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideHistoricalDataService(retrofit: Retrofit): HistoricalDataService {
        return retrofit.create(HistoricalDataService::class.java)
    }
}