package com.hakandindis.main.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hakandindis.network.weather.response.WeatherForecastResponse


@Composable
fun WeatherListView(data: WeatherForecastResponse) {
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            data.list?.let { weatherItems ->
                items(weatherItems) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        it.dtTxt?.let { date ->
                            Text(
                                text = date,
                                style = TextStyle(fontWeight = FontWeight.ExtraBold),
                            )
                        }
                        Box(modifier = Modifier) {
                            Row {
                                it.weather?.firstOrNull()?.icon?.let { url ->
                                    AsyncImage(
                                        modifier = Modifier
                                            .width(24.dp)
                                            .height(24.dp)
                                            .padding(end = 8.dp),
                                        model = "https://openweathermap.org/img/wn/$url@2x.png",
                                        contentDescription = "",
                                    )
                                }
                                it.main?.temp?.let { temp ->
                                    Text(
                                        text = temp.toString(),
                                        style = TextStyle(fontWeight = FontWeight.Bold)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}