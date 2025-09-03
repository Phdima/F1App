package com.example.f1app.data.repository

import android.util.Log.e
import com.example.f1app.data.network.api.OpenF1ApiService
import com.example.f1app.domain.model.DriverDomain
import com.example.f1app.domain.repository.DriversRepo

class DriversRepoImpl(
    private val apiService: OpenF1ApiService
) : DriversRepo {
    override suspend fun getDrivers(): Result<List<DriverDomain>> {
        return try {
            val response = apiService.getDrivers()
            if (response.isSuccessful) {
                val driversList = response.body()?.map { it.toDriverDomain() } ?: emptyList()
                Result.success(driversList)
            } else {
                Result.failure(Exception("API error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
