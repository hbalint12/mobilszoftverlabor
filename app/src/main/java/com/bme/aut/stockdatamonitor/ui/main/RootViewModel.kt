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
class RootViewModel @Inject constructor(
  repository: MainRepository
) : ViewModel() {
}