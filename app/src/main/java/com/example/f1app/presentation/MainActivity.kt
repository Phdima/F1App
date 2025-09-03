package com.example.f1app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.f1app.presentation.screens.DriversScreen
import com.example.f1app.presentation.theme.F1AppTheme
import com.example.f1app.presentation.viewmodels.DriversVM
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val driverVM: DriversVM = koinViewModel()
            F1AppTheme {
                DriversScreen(driverVM)
            }
        }
    }
}
