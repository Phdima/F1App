package com.example.f1app.data.network.api

import com.example.f1app.data.dto.DriverDto
import retrofit2.Response
import retrofit2.http.GET

interface OpenF1ApiService {
    @GET("drivers?session_key=latest")
        suspend fun getDrivers(): Response<List<DriverDto>>
}