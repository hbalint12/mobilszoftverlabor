package hu.bme.aut.android.stockdatamonitor.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.app.Application
import androidx.room.Room
import com.bme.aut.stockdatamonitor.R
import com.bme.aut.stockdatamonitor.persistence.AppDatabase
import com.bme.aut.stockdatamonitor.persistence.StockDataDao
import dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
                .databaseBuilder(
                        application,
                        AppDatabase::class.java,
                        application.getString(R.string.database)
                )
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideStockDataDao(appDatabase: AppDatabase): StockDataDao {
        return appDatabase.stockDataDao()
    }
}