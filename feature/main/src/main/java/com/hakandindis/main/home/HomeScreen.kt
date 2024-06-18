package com.hakandindis.main.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeRoute(
    appBarTitle: String,
    viewModel: HomeViewModel = hiltViewModel(),
) {

}

@Composable
fun HomeScreen(
    appBarTitle: String,
) {

}


@Preview
@Composable
internal fun HomeScreenPreview() {
    HomeScreen("")
}