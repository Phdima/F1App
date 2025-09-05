package com.example.f1app.data.dto

import com.example.f1app.domain.model.DriverDomain
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Locale

@JsonClass(generateAdapter = true)
data class DriverDto(
    @param:Json(name = "full_name") val name: String,
    @param:Json(name = "team_name") val team: String,
    @param:Json(name = "team_colour") val teamColor: String,
    @param:Json(name = "headshot_url") val headShot: String?,
    @param:Json(name = "country_code") val countryCode: Locale.IsoCountryCode?
) {
    fun toDriverDomain(): DriverDomain {
        return DriverDomain(
            name = name,
            team = team,
            teamColor = teamColor,
            headShot = headShot,
            countryCode = countryCode
        )
    }
}
