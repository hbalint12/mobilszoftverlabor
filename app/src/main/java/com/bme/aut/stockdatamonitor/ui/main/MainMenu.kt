package com.bme.aut.stockdatamonitor.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bme.aut.stockdatamonitor.ui.main.MainMenuModel.showMenu
import com.bme.aut.stockdatamonitor.R
@Composable
fun MainMenu(navController: NavController) {

    IconButton(onClick = { showMenu.value = true }) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_more_vert_black_24),
            contentDescription = "",
        )
    }
    if (showMenu.value.not()) {
        return
    }

    DropdownMenu(
        expanded =  showMenu.value,
        onDismissRequest = { showMenu.value = false }
    ) {
        DropdownMenuItem(onClick = {// Force a crash
            navController.navigate("home")
            showMenu.value = false
        }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "AAPL",
                color = MaterialTheme.colors.onSurface,
                maxLines = 1
            )
        }
        DropdownMenuItem(onClick = {
            navController.navigate("about")
            showMenu.value = false
        }) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "About",
                color = MaterialTheme.colors.onSurface,
                maxLines = 1
            )
        }
    }
}

