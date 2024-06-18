package com.hakandindis.domain.repository

import com.hakandindis.network.util.NetworkConstants
import com.hakandindis.network.weather.service.WeatherService
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val service: WeatherService,
) {

    suspend fun getWeatherForecast() = service.getWeatherForecast(
        lat = NetworkConstants.LATITUDE,
        lon = NetworkConstants.LONGITUDE,
        apiKey = NetworkConstants.API_KEY,
        units = "metric"
    )
}