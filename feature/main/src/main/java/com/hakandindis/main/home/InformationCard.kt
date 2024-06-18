package com.hakandindis.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hakandindis.network.weather.response.WeatherForecastResponse


@Composable
fun InformationCard(data: WeatherForecastResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = Shapes().small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            //https://openweathermap.org/img/wn/10d@2x.png
            AsyncImage(
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp),
                model = "https://openweathermap.org/img/wn/${data.list?.firstOrNull()?.weather?.firstOrNull()?.icon}@2x.png",
                contentDescription = ""
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                data.city?.let {
                    Text(text = "${it.name}, ${it.country}")
                }
                Spacer(modifier = Modifier.fillMaxWidth())
                data.list?.firstOrNull()?.weather?.firstOrNull()?.description?.let {
                    Text(text = it)
                }
            }
        }
    }
}