package com.bme.aut.stockdatamonitor.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bme.aut.stockdatamonitor.model.StockData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {

    val stockList: Flow<List<StockData>> =
        mainRepository.loadStockData(
            onStart = { _isLoading.value = true },
            onCompletion = { _isLoading.value = false },
            onError = {  }
        ) as Flow<List<StockData>>

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    init {

    }
}