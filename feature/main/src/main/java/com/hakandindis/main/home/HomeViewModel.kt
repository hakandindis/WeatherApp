package com.hakandindis.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hakandindis.base.ProcessResult
import com.hakandindis.domain.usecase.GetWeatherForecastUseCase
import com.hakandindis.network.weather.response.WeatherForecastResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
) : ViewModel() {

    private val _weatherState: MutableStateFlow<ProcessResult<WeatherForecastResponse>> =
        MutableStateFlow(ProcessResult.Initial)
    val weatherState: StateFlow<ProcessResult<WeatherForecastResponse>> = _weatherState

    init {
        getWeatherForecast()
    }

    private fun getWeatherForecast() {
        viewModelScope.launch {
            getWeatherForecastUseCase().collect {
                _weatherState.value = it
            }
        }
    }

}