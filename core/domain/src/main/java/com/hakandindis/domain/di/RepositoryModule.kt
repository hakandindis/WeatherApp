package com.hakandindis.domain.di

import com.hakandindis.domain.repository.WeatherRepositoryImpl
import com.hakandindis.network.weather.service.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTrackRepository(service: WeatherService): WeatherRepositoryImpl {
        return WeatherRepositoryImpl(service)
    }
}