package com.bme.aut.stockdatamonitor.ui.main


import com.bme.aut.stockdatamonitor.R
import androidx.compose.runtime.rememberCoroutineScope
import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bme.aut.stockdatamonitor.model.StockData
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HistData(
    viewModel: MainViewModel,
    navController: NavController,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope()
) {
    val stockData: List<StockData> by viewModel.stockList.collectAsState(initial = listOf())

    ConstraintLayout {
        val (body, progress) = createRefs()
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            },
            topBar = {
                TopAppBar(
                    title = { Text( "Historical data of AAPL" )},
                    backgroundColor = MaterialTheme.colors.primary,
                    actions = { MainMenu(navController) }
                )
            },
            content = {

                Column {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text("Symbol")
                    }
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text("Date")
                    }
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text("Price")
                    }
                }}

                LazyColumn(modifier = Modifier.padding(35.dp),
                    verticalArrangement = Arrangement.spacedBy(40.dp)) {
                        items(stockData) { message ->
                            Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly){
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(message.name)
                                }
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(message.date)
                                }
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(message.close.toString())
                                }
                                }

                         }
                     }
            }
        )

    }
}