package com.hakandindis.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hakandindis.base.ProcessResult
import com.hakandindis.network.weather.response.WeatherForecastResponse
import com.hakandindis.ui_components.progressbar.ProgressBar


@Composable
fun HomeRoute(
    appBarTitle: String,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.weatherState.collectAsStateWithLifecycle()
    HomeScreen(
        appBarTitle = appBarTitle,
        state = state.value,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    appBarTitle: String,
    state: ProcessResult<WeatherForecastResponse>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = appBarTitle)
                }
            )
        }
    ) { innerPadding ->
        when (state) {
            ProcessResult.Loading -> {
                ProgressBar()
            }

            is ProcessResult.Failure -> {

            }

            is ProcessResult.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(16.dp),
                ) {
                    InformationCard(data = state.data)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
                    WeatherListView(data = state.data)
                }
            }

            else -> {

            }
        }
    }
}


@Preview
@Composable
internal fun HomeScreenPreview() {
    HomeScreen(
        appBarTitle = "Home",
        state = ProcessResult.Success(
            WeatherForecastResponse(
                city = null,
                cod = null,
                message = null,
                cnt = null,
                list = null
            )
        )
    )
}