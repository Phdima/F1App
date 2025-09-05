package com.example.f1app.data.repository

import android.util.Log
import android.util.Log.e
import com.example.f1app.data.network.api.OpenF1ApiService
import com.example.f1app.domain.model.DriverDomain
import com.example.f1app.domain.repository.DriversRepo
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout

class DriversRepoImpl(
    private val apiService: OpenF1ApiService
) : DriversRepo {
    override suspend fun getDrivers(): Result<List<DriverDomain>> {
        return try {
            Log.d("API_DEBUG", "Sending request to API...")

            // Добавляем таймаут для диагностики
            try {
                withTimeout(30000) { // 30 секунд таймаут
                    val response = apiService.getDrivers()
                    Log.d("API_DEBUG", "Response received. Code: ${response.code()}")

                    if (response.isSuccessful) {
                        val driversList = response.body()?.map { it.toDriverDomain() } ?: emptyList()
                        Log.d("API_DEBUG", "Drivers list size: ${driversList.size}")
                        Result.success(driversList)
                    } else {
                        Log.e("API_ERROR", "Unsuccessful response: ${response.code()}, ${response.message()}")
                        Result.failure(Exception("API error: ${response.code()}"))
                    }
                }
            } catch (e: TimeoutCancellationException) {
                Log.e("API_ERROR", "Request timeout: ${e.message}")
                Result.failure(Exception("Request timeout"))
            }
        } catch (e: Exception) {
            Log.e("API_EXCEPTION", "Exception during API call: ${e.javaClass.simpleName}, ${e.message}")
            Result.failure(e)
        }
    }
}