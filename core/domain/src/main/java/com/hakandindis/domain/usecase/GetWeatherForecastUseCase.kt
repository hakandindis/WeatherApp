package com.hakandindis.domain.usecase

import com.hakandindis.base.ProcessResult
import com.hakandindis.domain.repository.WeatherRepositoryImpl
import com.hakandindis.network.weather.response.WeatherForecastResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherRepositoryImpl,
    private val dispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(): Flow<ProcessResult<WeatherForecastResponse>> = flow {
        try {
            emit(ProcessResult.Loading)
            val response = repository.getWeatherForecast()
            emit(ProcessResult.Success(response))
        } catch (e: Exception) {
            emit(ProcessResult.Failure(e))
        }
    }.flowOn(dispatcher)
}