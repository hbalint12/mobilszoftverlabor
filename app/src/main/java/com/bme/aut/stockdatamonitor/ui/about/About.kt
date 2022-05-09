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
fun About(navController: NavController) {

    ConstraintLayout {
        val (body, progress) = createRefs()
        Scaffold(
            backgroundColor = Color.Transparent,
            modifier = Modifier.constrainAs(body) {
                top.linkTo(parent.top)
            },
            topBar = {
                TopAppBar(
                    title = { Text( "About" )},
                    backgroundColor = MaterialTheme.colors.primary,
                    actions = { MainMenu(navController) }
                )
            },
            content = {
                Box(
                    contentAlignment = Alignment.Center, // you apply alignment to all children
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column {
                        Row(Modifier.align(Alignment.CenterHorizontally)) {
                            Text(
                                "About"// or to a specific child,
                            )
                        }
                        Row() {
                            Text(
                                "Application developed for Apple Inverstors"// or to a specific child,
                            )
                        }
                    }
                }

            }
        )

    }
}