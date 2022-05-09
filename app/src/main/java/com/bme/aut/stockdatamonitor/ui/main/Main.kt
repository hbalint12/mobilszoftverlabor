package com.bme.aut.stockdatamonitor.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun StockMainScreen() {
    StockTheme {
        Surface(color = Color.Transparent) {
            MainScreen()
        }
    }
}

