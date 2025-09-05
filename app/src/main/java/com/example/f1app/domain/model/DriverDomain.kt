package com.example.f1app.domain.model

import java.util.Locale

data class DriverDomain(
    val name: String,
    val team: String,
    val teamColor: String,
    val headShot: String?,
    val countryCode: Locale.IsoCountryCode?
)