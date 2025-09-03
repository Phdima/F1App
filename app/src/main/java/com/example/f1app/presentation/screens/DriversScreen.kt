package com.example.f1app.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.f1app.presentation.viewmodels.DriversVM

@Composable
fun DriversScreen(viewModel: DriversVM) {

    val drivers = viewModel.drivers.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(drivers.value) { driver ->
                Text(driver.name)

            }
        }
    }

}