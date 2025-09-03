package com.example.f1app.domain.repository

import com.example.f1app.domain.model.DriverDomain

interface DriversRepo {
    suspend fun getDrivers() : Result<List<DriverDomain>>
}