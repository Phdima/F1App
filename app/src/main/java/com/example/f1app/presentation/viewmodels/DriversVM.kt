package com.example.f1app.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1app.domain.model.DriverDomain
import com.example.f1app.domain.repository.DriversRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class DriversVM(
    val repo: DriversRepo
) : ViewModel() {

    private val _drivers = MutableStateFlow<List<DriverDomain>>(emptyList())
    val drivers = _drivers.asStateFlow()

    init {
        viewModelScope.launch {
            initializeDrivers()
        }
    }

    private suspend fun initializeDrivers() {
        repo.getDrivers().fold(
            onSuccess = { driversList -> _drivers.value = driversList },
            onFailure = { exception ->
                Log.e("DriversVM", "Error loading drivers", exception)
            }
        )
    }
}